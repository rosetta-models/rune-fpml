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
import fpml.confirmation.FacilityContractIdentifier;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LcAccrual;
import fpml.confirmation.LcPurpose;
import fpml.confirmation.LcType;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.LetterOfCredit.LetterOfCreditBuilder;
import fpml.confirmation.LetterOfCredit.LetterOfCreditBuilderImpl;
import fpml.confirmation.LetterOfCredit.LetterOfCreditImpl;
import fpml.confirmation.LetterOfCreditFeaturesModel;
import fpml.confirmation.LetterOfCreditRolesModel;
import fpml.confirmation.LetterOfCreditSummary;
import fpml.confirmation.LetterOfCreditSummary.LetterOfCreditSummaryBuilder;
import fpml.confirmation.LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl;
import fpml.confirmation.LetterOfCreditSummary.LetterOfCreditSummaryImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.meta.LetterOfCreditMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A definition of an unfunded borrowing (guarantee) instrument known as a Letter of Credit.
 * @version ${project.version}
 */
@RosettaDataType(value="LetterOfCredit", builder=LetterOfCredit.LetterOfCreditBuilderImpl.class, version="${project.version}")
public interface LetterOfCredit extends LetterOfCreditSummary {

	LetterOfCreditMeta metaData = new LetterOfCreditMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Expiry date of the letter of credit.
	 */
	Date getExpiryDate();
	/**
	 * Final expiry date of the letter of credit, once the evergreen option has been exercised.
	 */
	Date getFinalExpiryDate();
	/**
	 * The letter of credit fee rate details.
	 */
	LcAccrual getLcAccrual();
	/**
	 * Defines the purpose of a letter of credit.
	 */
	LcPurpose getPurpose();
	LetterOfCreditFeaturesModel getLetterOfCreditFeaturesModel();
	/**
	 * Defines exchange rate between the letter of credit and facility.
	 */
	FxTerms getFacilityFxRate();

	/*********************** Build Methods  ***********************/
	LetterOfCredit build();
	
	LetterOfCredit.LetterOfCreditBuilder toBuilder();
	
	static LetterOfCredit.LetterOfCreditBuilder builder() {
		return new LetterOfCredit.LetterOfCreditBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LetterOfCredit> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LetterOfCredit> getType() {
		return LetterOfCredit.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("identifier"), processor, FacilityContractIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("_type"), processor, LcType.class, get_type());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("letterOfCreditRolesModel"), processor, LetterOfCreditRolesModel.class, getLetterOfCreditRolesModel());
		processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.class, getAmount());
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("finalExpiryDate"), Date.class, getFinalExpiryDate(), this);
		processRosetta(path.newSubPath("lcAccrual"), processor, LcAccrual.class, getLcAccrual());
		processRosetta(path.newSubPath("purpose"), processor, LcPurpose.class, getPurpose());
		processRosetta(path.newSubPath("letterOfCreditFeaturesModel"), processor, LetterOfCreditFeaturesModel.class, getLetterOfCreditFeaturesModel());
		processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.class, getFacilityFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LetterOfCreditBuilder extends LetterOfCredit, LetterOfCreditSummary.LetterOfCreditSummaryBuilder {
		LcAccrual.LcAccrualBuilder getOrCreateLcAccrual();
		LcAccrual.LcAccrualBuilder getLcAccrual();
		LcPurpose.LcPurposeBuilder getOrCreatePurpose();
		LcPurpose.LcPurposeBuilder getPurpose();
		LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder getOrCreateLetterOfCreditFeaturesModel();
		LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder getLetterOfCreditFeaturesModel();
		FxTerms.FxTermsBuilder getOrCreateFacilityFxRate();
		FxTerms.FxTermsBuilder getFacilityFxRate();
		LetterOfCredit.LetterOfCreditBuilder addIdentifier(FacilityContractIdentifier identifier0);
		LetterOfCredit.LetterOfCreditBuilder addIdentifier(FacilityContractIdentifier identifier1, int _idx);
		LetterOfCredit.LetterOfCreditBuilder addIdentifier(List<? extends FacilityContractIdentifier> identifier2);
		LetterOfCredit.LetterOfCreditBuilder setIdentifier(List<? extends FacilityContractIdentifier> identifier3);
		LetterOfCredit.LetterOfCreditBuilder set_type(LcType _type);
		LetterOfCredit.LetterOfCreditBuilder setEffectiveDate(Date effectiveDate);
		LetterOfCredit.LetterOfCreditBuilder setLetterOfCreditRolesModel(LetterOfCreditRolesModel letterOfCreditRolesModel);
		LetterOfCredit.LetterOfCreditBuilder setAmount(MoneyWithParticipantShare amount);
		LetterOfCredit.LetterOfCreditBuilder setExpiryDate(Date expiryDate);
		LetterOfCredit.LetterOfCreditBuilder setFinalExpiryDate(Date finalExpiryDate);
		LetterOfCredit.LetterOfCreditBuilder setLcAccrual(LcAccrual lcAccrual);
		LetterOfCredit.LetterOfCreditBuilder setPurpose(LcPurpose purpose);
		LetterOfCredit.LetterOfCreditBuilder setLetterOfCreditFeaturesModel(LetterOfCreditFeaturesModel letterOfCreditFeaturesModel);
		LetterOfCredit.LetterOfCreditBuilder setFacilityFxRate(FxTerms facilityFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("identifier"), processor, FacilityContractIdentifier.FacilityContractIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("_type"), processor, LcType.LcTypeBuilder.class, get_type());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("letterOfCreditRolesModel"), processor, LetterOfCreditRolesModel.LetterOfCreditRolesModelBuilder.class, getLetterOfCreditRolesModel());
			processRosetta(path.newSubPath("amount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("finalExpiryDate"), Date.class, getFinalExpiryDate(), this);
			processRosetta(path.newSubPath("lcAccrual"), processor, LcAccrual.LcAccrualBuilder.class, getLcAccrual());
			processRosetta(path.newSubPath("purpose"), processor, LcPurpose.LcPurposeBuilder.class, getPurpose());
			processRosetta(path.newSubPath("letterOfCreditFeaturesModel"), processor, LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder.class, getLetterOfCreditFeaturesModel());
			processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.FxTermsBuilder.class, getFacilityFxRate());
		}
		

		LetterOfCredit.LetterOfCreditBuilder prune();
	}

	/*********************** Immutable Implementation of LetterOfCredit  ***********************/
	class LetterOfCreditImpl extends LetterOfCreditSummary.LetterOfCreditSummaryImpl implements LetterOfCredit {
		private final Date expiryDate;
		private final Date finalExpiryDate;
		private final LcAccrual lcAccrual;
		private final LcPurpose purpose;
		private final LetterOfCreditFeaturesModel letterOfCreditFeaturesModel;
		private final FxTerms facilityFxRate;
		
		protected LetterOfCreditImpl(LetterOfCredit.LetterOfCreditBuilder builder) {
			super(builder);
			this.expiryDate = builder.getExpiryDate();
			this.finalExpiryDate = builder.getFinalExpiryDate();
			this.lcAccrual = ofNullable(builder.getLcAccrual()).map(f->f.build()).orElse(null);
			this.purpose = ofNullable(builder.getPurpose()).map(f->f.build()).orElse(null);
			this.letterOfCreditFeaturesModel = ofNullable(builder.getLetterOfCreditFeaturesModel()).map(f->f.build()).orElse(null);
			this.facilityFxRate = ofNullable(builder.getFacilityFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		public Date getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("lcAccrual")
		public LcAccrual getLcAccrual() {
			return lcAccrual;
		}
		
		@Override
		@RosettaAttribute("purpose")
		public LcPurpose getPurpose() {
			return purpose;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditFeaturesModel")
		public LetterOfCreditFeaturesModel getLetterOfCreditFeaturesModel() {
			return letterOfCreditFeaturesModel;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		public FxTerms getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public LetterOfCredit build() {
			return this;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder toBuilder() {
			LetterOfCredit.LetterOfCreditBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LetterOfCredit.LetterOfCreditBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getFinalExpiryDate()).ifPresent(builder::setFinalExpiryDate);
			ofNullable(getLcAccrual()).ifPresent(builder::setLcAccrual);
			ofNullable(getPurpose()).ifPresent(builder::setPurpose);
			ofNullable(getLetterOfCreditFeaturesModel()).ifPresent(builder::setLetterOfCreditFeaturesModel);
			ofNullable(getFacilityFxRate()).ifPresent(builder::setFacilityFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LetterOfCredit _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(lcAccrual, _that.getLcAccrual())) return false;
			if (!Objects.equals(purpose, _that.getPurpose())) return false;
			if (!Objects.equals(letterOfCreditFeaturesModel, _that.getLetterOfCreditFeaturesModel())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (lcAccrual != null ? lcAccrual.hashCode() : 0);
			_result = 31 * _result + (purpose != null ? purpose.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditFeaturesModel != null ? letterOfCreditFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCredit {" +
				"expiryDate=" + this.expiryDate + ", " +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"lcAccrual=" + this.lcAccrual + ", " +
				"purpose=" + this.purpose + ", " +
				"letterOfCreditFeaturesModel=" + this.letterOfCreditFeaturesModel + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LetterOfCredit  ***********************/
	class LetterOfCreditBuilderImpl extends LetterOfCreditSummary.LetterOfCreditSummaryBuilderImpl  implements LetterOfCredit.LetterOfCreditBuilder {
	
		protected Date expiryDate;
		protected Date finalExpiryDate;
		protected LcAccrual.LcAccrualBuilder lcAccrual;
		protected LcPurpose.LcPurposeBuilder purpose;
		protected LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder letterOfCreditFeaturesModel;
		protected FxTerms.FxTermsBuilder facilityFxRate;
	
		public LetterOfCreditBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		public Date getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("lcAccrual")
		public LcAccrual.LcAccrualBuilder getLcAccrual() {
			return lcAccrual;
		}
		
		@Override
		public LcAccrual.LcAccrualBuilder getOrCreateLcAccrual() {
			LcAccrual.LcAccrualBuilder result;
			if (lcAccrual!=null) {
				result = lcAccrual;
			}
			else {
				result = lcAccrual = LcAccrual.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("purpose")
		public LcPurpose.LcPurposeBuilder getPurpose() {
			return purpose;
		}
		
		@Override
		public LcPurpose.LcPurposeBuilder getOrCreatePurpose() {
			LcPurpose.LcPurposeBuilder result;
			if (purpose!=null) {
				result = purpose;
			}
			else {
				result = purpose = LcPurpose.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditFeaturesModel")
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder getLetterOfCreditFeaturesModel() {
			return letterOfCreditFeaturesModel;
		}
		
		@Override
		public LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder getOrCreateLetterOfCreditFeaturesModel() {
			LetterOfCreditFeaturesModel.LetterOfCreditFeaturesModelBuilder result;
			if (letterOfCreditFeaturesModel!=null) {
				result = letterOfCreditFeaturesModel;
			}
			else {
				result = letterOfCreditFeaturesModel = LetterOfCreditFeaturesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		public FxTerms.FxTermsBuilder getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateFacilityFxRate() {
			FxTerms.FxTermsBuilder result;
			if (facilityFxRate!=null) {
				result = facilityFxRate;
			}
			else {
				result = facilityFxRate = FxTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder addIdentifier(FacilityContractIdentifier identifier) {
			if (identifier!=null) this.identifier.add(identifier.toBuilder());
			return this;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder addIdentifier(FacilityContractIdentifier identifier, int _idx) {
			getIndex(this.identifier, _idx, () -> identifier.toBuilder());
			return this;
		}
		@Override 
		public LetterOfCredit.LetterOfCreditBuilder addIdentifier(List<? extends FacilityContractIdentifier> identifiers) {
			if (identifiers != null) {
				for (FacilityContractIdentifier toAdd : identifiers) {
					this.identifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("identifier")
		public LetterOfCredit.LetterOfCreditBuilder setIdentifier(List<? extends FacilityContractIdentifier> identifiers) {
			if (identifiers == null)  {
				this.identifier = new ArrayList<>();
			}
			else {
				this.identifier = identifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("_type")
		public LetterOfCredit.LetterOfCreditBuilder set_type(LcType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LetterOfCredit.LetterOfCreditBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditRolesModel")
		public LetterOfCredit.LetterOfCreditBuilder setLetterOfCreditRolesModel(LetterOfCreditRolesModel letterOfCreditRolesModel) {
			this.letterOfCreditRolesModel = letterOfCreditRolesModel==null?null:letterOfCreditRolesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public LetterOfCredit.LetterOfCreditBuilder setAmount(MoneyWithParticipantShare amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expiryDate")
		public LetterOfCredit.LetterOfCreditBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("finalExpiryDate")
		public LetterOfCredit.LetterOfCreditBuilder setFinalExpiryDate(Date finalExpiryDate) {
			this.finalExpiryDate = finalExpiryDate==null?null:finalExpiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("lcAccrual")
		public LetterOfCredit.LetterOfCreditBuilder setLcAccrual(LcAccrual lcAccrual) {
			this.lcAccrual = lcAccrual==null?null:lcAccrual.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("purpose")
		public LetterOfCredit.LetterOfCreditBuilder setPurpose(LcPurpose purpose) {
			this.purpose = purpose==null?null:purpose.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditFeaturesModel")
		public LetterOfCredit.LetterOfCreditBuilder setLetterOfCreditFeaturesModel(LetterOfCreditFeaturesModel letterOfCreditFeaturesModel) {
			this.letterOfCreditFeaturesModel = letterOfCreditFeaturesModel==null?null:letterOfCreditFeaturesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFxRate")
		public LetterOfCredit.LetterOfCreditBuilder setFacilityFxRate(FxTerms facilityFxRate) {
			this.facilityFxRate = facilityFxRate==null?null:facilityFxRate.toBuilder();
			return this;
		}
		
		@Override
		public LetterOfCredit build() {
			return new LetterOfCredit.LetterOfCreditImpl(this);
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder prune() {
			super.prune();
			if (lcAccrual!=null && !lcAccrual.prune().hasData()) lcAccrual = null;
			if (purpose!=null && !purpose.prune().hasData()) purpose = null;
			if (letterOfCreditFeaturesModel!=null && !letterOfCreditFeaturesModel.prune().hasData()) letterOfCreditFeaturesModel = null;
			if (facilityFxRate!=null && !facilityFxRate.prune().hasData()) facilityFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpiryDate()!=null) return true;
			if (getFinalExpiryDate()!=null) return true;
			if (getLcAccrual()!=null && getLcAccrual().hasData()) return true;
			if (getPurpose()!=null && getPurpose().hasData()) return true;
			if (getLetterOfCreditFeaturesModel()!=null && getLetterOfCreditFeaturesModel().hasData()) return true;
			if (getFacilityFxRate()!=null && getFacilityFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LetterOfCredit.LetterOfCreditBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LetterOfCredit.LetterOfCreditBuilder o = (LetterOfCredit.LetterOfCreditBuilder) other;
			
			merger.mergeRosetta(getLcAccrual(), o.getLcAccrual(), this::setLcAccrual);
			merger.mergeRosetta(getPurpose(), o.getPurpose(), this::setPurpose);
			merger.mergeRosetta(getLetterOfCreditFeaturesModel(), o.getLetterOfCreditFeaturesModel(), this::setLetterOfCreditFeaturesModel);
			merger.mergeRosetta(getFacilityFxRate(), o.getFacilityFxRate(), this::setFacilityFxRate);
			
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getFinalExpiryDate(), o.getFinalExpiryDate(), this::setFinalExpiryDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LetterOfCredit _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(lcAccrual, _that.getLcAccrual())) return false;
			if (!Objects.equals(purpose, _that.getPurpose())) return false;
			if (!Objects.equals(letterOfCreditFeaturesModel, _that.getLetterOfCreditFeaturesModel())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (lcAccrual != null ? lcAccrual.hashCode() : 0);
			_result = 31 * _result + (purpose != null ? purpose.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditFeaturesModel != null ? letterOfCreditFeaturesModel.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LetterOfCreditBuilder {" +
				"expiryDate=" + this.expiryDate + ", " +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"lcAccrual=" + this.lcAccrual + ", " +
				"purpose=" + this.purpose + ", " +
				"letterOfCreditFeaturesModel=" + this.letterOfCreditFeaturesModel + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}
}
