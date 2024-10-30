package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.CouponType;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.FixedIncomeSecurityContentModel;
import fpml.confirmation.FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder;
import fpml.confirmation.FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilderImpl;
import fpml.confirmation.FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.FixedIncomeSecurityContentModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group that specifies Bond Content elements.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FixedIncomeSecurityContentModel", builder=FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FixedIncomeSecurityContentModel extends RosettaModelObject {

	FixedIncomeSecurityContentModelMeta metaData = new FixedIncomeSecurityContentModelMeta();

	/*********************** Getter Methods  ***********************/
	String getIssuerName();
	PartyReference getIssuerPartyReference();
	/**
	 * The repayment precedence of a debt instrument.
	 */
	CreditSeniority getSeniority();
	/**
	 * Specifies if the bond has a variable coupon, step-up/down coupon or a zero-coupon.
	 */
	CouponType getCouponType();
	/**
	 * Specifies the coupon rate (expressed in percentage) of a fixed income security or convertible bond.
	 */
	BigDecimal getCouponRate();
	/**
	 * The date when the principal amount of a security becomes due and payable.
	 */
	Date getMaturity();

	/*********************** Build Methods  ***********************/
	FixedIncomeSecurityContentModel build();
	
	FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder toBuilder();
	
	static FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder builder() {
		return new FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedIncomeSecurityContentModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FixedIncomeSecurityContentModel> getType() {
		return FixedIncomeSecurityContentModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("issuerName"), String.class, getIssuerName(), this);
		processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.class, getIssuerPartyReference());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processRosetta(path.newSubPath("couponType"), processor, CouponType.class, getCouponType());
		processor.processBasic(path.newSubPath("couponRate"), BigDecimal.class, getCouponRate(), this);
		processor.processBasic(path.newSubPath("maturity"), Date.class, getMaturity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedIncomeSecurityContentModelBuilder extends FixedIncomeSecurityContentModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference();
		PartyReference.PartyReferenceBuilder getIssuerPartyReference();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		CouponType.CouponTypeBuilder getOrCreateCouponType();
		CouponType.CouponTypeBuilder getCouponType();
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setIssuerName(String issuerName);
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setSeniority(CreditSeniority seniority);
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setCouponType(CouponType couponType);
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setCouponRate(BigDecimal couponRate);
		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setMaturity(Date maturity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("issuerName"), String.class, getIssuerName(), this);
			processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIssuerPartyReference());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processRosetta(path.newSubPath("couponType"), processor, CouponType.CouponTypeBuilder.class, getCouponType());
			processor.processBasic(path.newSubPath("couponRate"), BigDecimal.class, getCouponRate(), this);
			processor.processBasic(path.newSubPath("maturity"), Date.class, getMaturity(), this);
		}
		

		FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder prune();
	}

	/*********************** Immutable Implementation of FixedIncomeSecurityContentModel  ***********************/
	class FixedIncomeSecurityContentModelImpl implements FixedIncomeSecurityContentModel {
		private final String issuerName;
		private final PartyReference issuerPartyReference;
		private final CreditSeniority seniority;
		private final CouponType couponType;
		private final BigDecimal couponRate;
		private final Date maturity;
		
		protected FixedIncomeSecurityContentModelImpl(FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder builder) {
			this.issuerName = builder.getIssuerName();
			this.issuerPartyReference = ofNullable(builder.getIssuerPartyReference()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.couponType = ofNullable(builder.getCouponType()).map(f->f.build()).orElse(null);
			this.couponRate = builder.getCouponRate();
			this.maturity = builder.getMaturity();
		}
		
		@Override
		@RosettaAttribute("issuerName")
		public String getIssuerName() {
			return issuerName;
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		public PartyReference getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("couponType")
		public CouponType getCouponType() {
			return couponType;
		}
		
		@Override
		@RosettaAttribute("couponRate")
		public BigDecimal getCouponRate() {
			return couponRate;
		}
		
		@Override
		@RosettaAttribute("maturity")
		public Date getMaturity() {
			return maturity;
		}
		
		@Override
		public FixedIncomeSecurityContentModel build() {
			return this;
		}
		
		@Override
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder toBuilder() {
			FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder builder) {
			ofNullable(getIssuerName()).ifPresent(builder::setIssuerName);
			ofNullable(getIssuerPartyReference()).ifPresent(builder::setIssuerPartyReference);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getCouponType()).ifPresent(builder::setCouponType);
			ofNullable(getCouponRate()).ifPresent(builder::setCouponRate);
			ofNullable(getMaturity()).ifPresent(builder::setMaturity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedIncomeSecurityContentModel _that = getType().cast(o);
		
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(couponType, _that.getCouponType())) return false;
			if (!Objects.equals(couponRate, _that.getCouponRate())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (couponType != null ? couponType.hashCode() : 0);
			_result = 31 * _result + (couponRate != null ? couponRate.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedIncomeSecurityContentModel {" +
				"issuerName=" + this.issuerName + ", " +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"seniority=" + this.seniority + ", " +
				"couponType=" + this.couponType + ", " +
				"couponRate=" + this.couponRate + ", " +
				"maturity=" + this.maturity +
			'}';
		}
	}

	/*********************** Builder Implementation of FixedIncomeSecurityContentModel  ***********************/
	class FixedIncomeSecurityContentModelBuilderImpl implements FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder {
	
		protected String issuerName;
		protected PartyReference.PartyReferenceBuilder issuerPartyReference;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected CouponType.CouponTypeBuilder couponType;
		protected BigDecimal couponRate;
		protected Date maturity;
	
		public FixedIncomeSecurityContentModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("issuerName")
		public String getIssuerName() {
			return issuerName;
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		public PartyReference.PartyReferenceBuilder getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (issuerPartyReference!=null) {
				result = issuerPartyReference;
			}
			else {
				result = issuerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("couponType")
		public CouponType.CouponTypeBuilder getCouponType() {
			return couponType;
		}
		
		@Override
		public CouponType.CouponTypeBuilder getOrCreateCouponType() {
			CouponType.CouponTypeBuilder result;
			if (couponType!=null) {
				result = couponType;
			}
			else {
				result = couponType = CouponType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("couponRate")
		public BigDecimal getCouponRate() {
			return couponRate;
		}
		
		@Override
		@RosettaAttribute("maturity")
		public Date getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("issuerName")
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setIssuerName(String issuerName) {
			this.issuerName = issuerName==null?null:issuerName;
			return this;
		}
		@Override
		@RosettaAttribute("issuerPartyReference")
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setIssuerPartyReference(PartyReference issuerPartyReference) {
			this.issuerPartyReference = issuerPartyReference==null?null:issuerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("seniority")
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setSeniority(CreditSeniority seniority) {
			this.seniority = seniority==null?null:seniority.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("couponType")
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setCouponType(CouponType couponType) {
			this.couponType = couponType==null?null:couponType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("couponRate")
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setCouponRate(BigDecimal couponRate) {
			this.couponRate = couponRate==null?null:couponRate;
			return this;
		}
		@Override
		@RosettaAttribute("maturity")
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder setMaturity(Date maturity) {
			this.maturity = maturity==null?null:maturity;
			return this;
		}
		
		@Override
		public FixedIncomeSecurityContentModel build() {
			return new FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelImpl(this);
		}
		
		@Override
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder prune() {
			if (issuerPartyReference!=null && !issuerPartyReference.prune().hasData()) issuerPartyReference = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			if (couponType!=null && !couponType.prune().hasData()) couponType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIssuerName()!=null) return true;
			if (getIssuerPartyReference()!=null && getIssuerPartyReference().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getCouponType()!=null && getCouponType().hasData()) return true;
			if (getCouponRate()!=null) return true;
			if (getMaturity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder o = (FixedIncomeSecurityContentModel.FixedIncomeSecurityContentModelBuilder) other;
			
			merger.mergeRosetta(getIssuerPartyReference(), o.getIssuerPartyReference(), this::setIssuerPartyReference);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeRosetta(getCouponType(), o.getCouponType(), this::setCouponType);
			
			merger.mergeBasic(getIssuerName(), o.getIssuerName(), this::setIssuerName);
			merger.mergeBasic(getCouponRate(), o.getCouponRate(), this::setCouponRate);
			merger.mergeBasic(getMaturity(), o.getMaturity(), this::setMaturity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedIncomeSecurityContentModel _that = getType().cast(o);
		
			if (!Objects.equals(issuerName, _that.getIssuerName())) return false;
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(couponType, _that.getCouponType())) return false;
			if (!Objects.equals(couponRate, _that.getCouponRate())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (issuerName != null ? issuerName.hashCode() : 0);
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (couponType != null ? couponType.hashCode() : 0);
			_result = 31 * _result + (couponRate != null ? couponRate.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedIncomeSecurityContentModelBuilder {" +
				"issuerName=" + this.issuerName + ", " +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"seniority=" + this.seniority + ", " +
				"couponType=" + this.couponType + ", " +
				"couponRate=" + this.couponRate + ", " +
				"maturity=" + this.maturity +
			'}';
		}
	}
}
