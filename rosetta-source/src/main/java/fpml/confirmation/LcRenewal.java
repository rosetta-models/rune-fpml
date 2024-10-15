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
import fpml.confirmation.LcRenewal;
import fpml.confirmation.LcRenewal.LcRenewalBuilder;
import fpml.confirmation.LcRenewal.LcRenewalBuilderImpl;
import fpml.confirmation.LcRenewal.LcRenewalImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.meta.LcRenewalMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing a change in the maturity date on an outstanding letter of credit.
 * @version ${project.version}
 */
@RosettaDataType(value="LcRenewal", builder=LcRenewal.LcRenewalBuilderImpl.class, version="${project.version}")
public interface LcRenewal extends AbstractLcEvent {

	LcRenewalMeta metaData = new LcRenewalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The final letter of credit expiry date (as defined by the evergreen option).
	 */
	Date getFinalExpiryDate();
	/**
	 * The original maturity date of the letter of credit.
	 */
	Date getMaturityDate();

	/*********************** Build Methods  ***********************/
	LcRenewal build();
	
	LcRenewal.LcRenewalBuilder toBuilder();
	
	static LcRenewal.LcRenewalBuilder builder() {
		return new LcRenewal.LcRenewalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcRenewal> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcRenewal> getType() {
		return LcRenewal.class;
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
		processor.processBasic(path.newSubPath("finalExpiryDate"), Date.class, getFinalExpiryDate(), this);
		processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcRenewalBuilder extends LcRenewal, AbstractLcEvent.AbstractLcEventBuilder {
		LcRenewal.LcRenewalBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LcRenewal.LcRenewalBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LcRenewal.LcRenewalBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LcRenewal.LcRenewalBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LcRenewal.LcRenewalBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LcRenewal.LcRenewalBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LcRenewal.LcRenewalBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LcRenewal.LcRenewalBuilder setComment(String comment);
		LcRenewal.LcRenewalBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LcRenewal.LcRenewalBuilder setEffectiveDate(Date effectiveDate);
		LcRenewal.LcRenewalBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcRenewal.LcRenewalBuilder setFinalExpiryDate(Date finalExpiryDate);
		LcRenewal.LcRenewalBuilder setMaturityDate(Date maturityDate);

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
			processor.processBasic(path.newSubPath("finalExpiryDate"), Date.class, getFinalExpiryDate(), this);
			processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
		}
		

		LcRenewal.LcRenewalBuilder prune();
	}

	/*********************** Immutable Implementation of LcRenewal  ***********************/
	class LcRenewalImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcRenewal {
		private final Date finalExpiryDate;
		private final Date maturityDate;
		
		protected LcRenewalImpl(LcRenewal.LcRenewalBuilder builder) {
			super(builder);
			this.finalExpiryDate = builder.getFinalExpiryDate();
			this.maturityDate = builder.getMaturityDate();
		}
		
		@Override
		@RosettaAttribute("finalExpiryDate")
		public Date getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		public LcRenewal build() {
			return this;
		}
		
		@Override
		public LcRenewal.LcRenewalBuilder toBuilder() {
			LcRenewal.LcRenewalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcRenewal.LcRenewalBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFinalExpiryDate()).ifPresent(builder::setFinalExpiryDate);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcRenewal _that = getType().cast(o);
		
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcRenewal {" +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"maturityDate=" + this.maturityDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcRenewal  ***********************/
	class LcRenewalBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl  implements LcRenewal.LcRenewalBuilder {
	
		protected Date finalExpiryDate;
		protected Date maturityDate;
	
		public LcRenewalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("finalExpiryDate")
		public Date getFinalExpiryDate() {
			return finalExpiryDate;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		public LcRenewal.LcRenewalBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcRenewal.LcRenewalBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LcRenewal.LcRenewalBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LcRenewal.LcRenewalBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcRenewal.LcRenewalBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LcRenewal.LcRenewalBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LcRenewal.LcRenewalBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LcRenewal.LcRenewalBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LcRenewal.LcRenewalBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LcRenewal.LcRenewalBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LcRenewal.LcRenewalBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference) {
			this.letterOfCreditReference = letterOfCreditReference==null?null:letterOfCreditReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("finalExpiryDate")
		public LcRenewal.LcRenewalBuilder setFinalExpiryDate(Date finalExpiryDate) {
			this.finalExpiryDate = finalExpiryDate==null?null:finalExpiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("maturityDate")
		public LcRenewal.LcRenewalBuilder setMaturityDate(Date maturityDate) {
			this.maturityDate = maturityDate==null?null:maturityDate;
			return this;
		}
		
		@Override
		public LcRenewal build() {
			return new LcRenewal.LcRenewalImpl(this);
		}
		
		@Override
		public LcRenewal.LcRenewalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcRenewal.LcRenewalBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFinalExpiryDate()!=null) return true;
			if (getMaturityDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcRenewal.LcRenewalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcRenewal.LcRenewalBuilder o = (LcRenewal.LcRenewalBuilder) other;
			
			
			merger.mergeBasic(getFinalExpiryDate(), o.getFinalExpiryDate(), this::setFinalExpiryDate);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcRenewal _that = getType().cast(o);
		
			if (!Objects.equals(finalExpiryDate, _that.getFinalExpiryDate())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (finalExpiryDate != null ? finalExpiryDate.hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcRenewalBuilder {" +
				"finalExpiryDate=" + this.finalExpiryDate + ", " +
				"maturityDate=" + this.maturityDate +
			'}' + " " + super.toString();
		}
	}
}
