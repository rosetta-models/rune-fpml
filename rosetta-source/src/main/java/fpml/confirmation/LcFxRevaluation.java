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
import fpml.confirmation.AbstractLcEvent;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventBuilder;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventBuilderImpl;
import fpml.confirmation.AbstractLcEvent.AbstractLcEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FxTerms;
import fpml.confirmation.LcFxRevaluation;
import fpml.confirmation.LcFxRevaluation.LcFxRevaluationBuilder;
import fpml.confirmation.LcFxRevaluation.LcFxRevaluationBuilderImpl;
import fpml.confirmation.LcFxRevaluation.LcFxRevaluationImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.meta.LcFxRevaluationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a change in either the [L/C -&amp;gt; Facility] or [Accrual -&amp;gt; L/C] FX rates (or both) on an outstanding letter of credit.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LcFxRevaluation", builder=LcFxRevaluation.LcFxRevaluationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LcFxRevaluation extends AbstractLcEvent {

	LcFxRevaluationMeta metaData = new LcFxRevaluationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines exchange rate between the letter of credit accrual and letter of credit currencies.
	 */
	FxTerms getLcFxRate();
	/**
	 * Defines exchange rate between the letter of credit and facility.
	 */
	FxTerms getFacilityFxRate();

	/*********************** Build Methods  ***********************/
	LcFxRevaluation build();
	
	LcFxRevaluation.LcFxRevaluationBuilder toBuilder();
	
	static LcFxRevaluation.LcFxRevaluationBuilder builder() {
		return new LcFxRevaluation.LcFxRevaluationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcFxRevaluation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcFxRevaluation> getType() {
		return LcFxRevaluation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
		processRosetta(path.newSubPath("lcFxRate"), processor, FxTerms.class, getLcFxRate());
		processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.class, getFacilityFxRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcFxRevaluationBuilder extends LcFxRevaluation, AbstractLcEvent.AbstractLcEventBuilder {
		FxTerms.FxTermsBuilder getOrCreateLcFxRate();
		FxTerms.FxTermsBuilder getLcFxRate();
		FxTerms.FxTermsBuilder getOrCreateFacilityFxRate();
		FxTerms.FxTermsBuilder getFacilityFxRate();
		LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LcFxRevaluation.LcFxRevaluationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LcFxRevaluation.LcFxRevaluationBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LcFxRevaluation.LcFxRevaluationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LcFxRevaluation.LcFxRevaluationBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LcFxRevaluation.LcFxRevaluationBuilder setComment(String comment);
		LcFxRevaluation.LcFxRevaluationBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LcFxRevaluation.LcFxRevaluationBuilder setEffectiveDate(Date effectiveDate);
		LcFxRevaluation.LcFxRevaluationBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcFxRevaluation.LcFxRevaluationBuilder setLcFxRate(FxTerms lcFxRate);
		LcFxRevaluation.LcFxRevaluationBuilder setFacilityFxRate(FxTerms facilityFxRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
			processRosetta(path.newSubPath("lcFxRate"), processor, FxTerms.FxTermsBuilder.class, getLcFxRate());
			processRosetta(path.newSubPath("facilityFxRate"), processor, FxTerms.FxTermsBuilder.class, getFacilityFxRate());
		}
		

		LcFxRevaluation.LcFxRevaluationBuilder prune();
	}

	/*********************** Immutable Implementation of LcFxRevaluation  ***********************/
	class LcFxRevaluationImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcFxRevaluation {
		private final FxTerms lcFxRate;
		private final FxTerms facilityFxRate;
		
		protected LcFxRevaluationImpl(LcFxRevaluation.LcFxRevaluationBuilder builder) {
			super(builder);
			this.lcFxRate = ofNullable(builder.getLcFxRate()).map(f->f.build()).orElse(null);
			this.facilityFxRate = ofNullable(builder.getFacilityFxRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lcFxRate")
		public FxTerms getLcFxRate() {
			return lcFxRate;
		}
		
		@Override
		@RosettaAttribute("facilityFxRate")
		public FxTerms getFacilityFxRate() {
			return facilityFxRate;
		}
		
		@Override
		public LcFxRevaluation build() {
			return this;
		}
		
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder toBuilder() {
			LcFxRevaluation.LcFxRevaluationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcFxRevaluation.LcFxRevaluationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLcFxRate()).ifPresent(builder::setLcFxRate);
			ofNullable(getFacilityFxRate()).ifPresent(builder::setFacilityFxRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcFxRevaluation _that = getType().cast(o);
		
			if (!Objects.equals(lcFxRate, _that.getLcFxRate())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcFxRate != null ? lcFxRate.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcFxRevaluation {" +
				"lcFxRate=" + this.lcFxRate + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcFxRevaluation  ***********************/
	class LcFxRevaluationBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl  implements LcFxRevaluation.LcFxRevaluationBuilder {
	
		protected FxTerms.FxTermsBuilder lcFxRate;
		protected FxTerms.FxTermsBuilder facilityFxRate;
	
		public LcFxRevaluationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lcFxRate")
		public FxTerms.FxTermsBuilder getLcFxRate() {
			return lcFxRate;
		}
		
		@Override
		public FxTerms.FxTermsBuilder getOrCreateLcFxRate() {
			FxTerms.FxTermsBuilder result;
			if (lcFxRate!=null) {
				result = lcFxRate;
			}
			else {
				result = lcFxRate = FxTerms.builder();
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
		@RosettaAttribute("eventIdentifier")
		public LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LcFxRevaluation.LcFxRevaluationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LcFxRevaluation.LcFxRevaluationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public LcFxRevaluation.LcFxRevaluationBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LcFxRevaluation.LcFxRevaluationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LcFxRevaluation.LcFxRevaluationBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LcFxRevaluation.LcFxRevaluationBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LcFxRevaluation.LcFxRevaluationBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LcFxRevaluation.LcFxRevaluationBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LcFxRevaluation.LcFxRevaluationBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference) {
			this.letterOfCreditReference = letterOfCreditReference==null?null:letterOfCreditReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lcFxRate")
		public LcFxRevaluation.LcFxRevaluationBuilder setLcFxRate(FxTerms lcFxRate) {
			this.lcFxRate = lcFxRate==null?null:lcFxRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("facilityFxRate")
		public LcFxRevaluation.LcFxRevaluationBuilder setFacilityFxRate(FxTerms facilityFxRate) {
			this.facilityFxRate = facilityFxRate==null?null:facilityFxRate.toBuilder();
			return this;
		}
		
		@Override
		public LcFxRevaluation build() {
			return new LcFxRevaluation.LcFxRevaluationImpl(this);
		}
		
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder prune() {
			super.prune();
			if (lcFxRate!=null && !lcFxRate.prune().hasData()) lcFxRate = null;
			if (facilityFxRate!=null && !facilityFxRate.prune().hasData()) facilityFxRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLcFxRate()!=null && getLcFxRate().hasData()) return true;
			if (getFacilityFxRate()!=null && getFacilityFxRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcFxRevaluation.LcFxRevaluationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcFxRevaluation.LcFxRevaluationBuilder o = (LcFxRevaluation.LcFxRevaluationBuilder) other;
			
			merger.mergeRosetta(getLcFxRate(), o.getLcFxRate(), this::setLcFxRate);
			merger.mergeRosetta(getFacilityFxRate(), o.getFacilityFxRate(), this::setFacilityFxRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcFxRevaluation _that = getType().cast(o);
		
			if (!Objects.equals(lcFxRate, _that.getLcFxRate())) return false;
			if (!Objects.equals(facilityFxRate, _that.getFacilityFxRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcFxRate != null ? lcFxRate.hashCode() : 0);
			_result = 31 * _result + (facilityFxRate != null ? facilityFxRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcFxRevaluationBuilder {" +
				"lcFxRate=" + this.lcFxRate + ", " +
				"facilityFxRate=" + this.facilityFxRate +
			'}' + " " + super.toString();
		}
	}
}
