package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.CRLReason;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.NameConstraints;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.util.Arrays;

public class RFC3280CertPathUtilities
{
    protected static final String CERTIFICATE_POLICIES = X509Extensions.CertificatePolicies.getId();

    protected static final String POLICY_MAPPINGS = X509Extensions.PolicyMappings.getId();

    protected static final String INHIBIT_ANY_POLICY = X509Extensions.InhibitAnyPolicy.getId();

    protected static final String ISSUING_DISTRIBUTION_POINT = X509Extensions.IssuingDistributionPoint.getId();

    protected static final String FRESHEST_CRL = X509Extensions.FreshestCRL.getId();

    protected static final String DELTA_CRL_INDICATOR = X509Extensions.DeltaCRLIndicator.getId();

    protected static final String POLICY_CONSTRAINTS = X509Extensions.PolicyConstraints.getId();

    protected static final String BASIC_CONSTRAINTS = X509Extensions.BasicConstraints.getId();

    protected static final String CRL_DISTRIBUTION_POINTS = X509Extensions.CRLDistributionPoints.getId();

    protected static final String SUBJECT_ALTERNATIVE_NAME = X509Extensions.SubjectAlternativeName.getId();

    protected static final String NAME_CONSTRAINTS = X509Extensions.NameConstraints.getId();

    protected static final String AUTHORITY_KEY_IDENTIFIER = X509Extensions.AuthorityKeyIdentifier.getId();

    protected static final String KEY_USAGE = X509Extensions.KeyUsage.getId();

    protected static final String CRL_NUMBER = X509Extensions.CRLNumber.getId();

    protected static final String ANY_POLICY = "2.5.29.32.0";

    /*
     * key usage bits
     */
    protected static final int KEY_CERT_SIGN = 5;

    protected static final int CRL_SIGN = 6;

}
