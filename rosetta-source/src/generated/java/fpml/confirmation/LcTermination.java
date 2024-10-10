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
import fpml.confirmation.LcTermination;
import fpml.confirmation.LcTermination.LcTerminationBuilder;
import fpml.confirmation.LcTermination.LcTerminationBuilderImpl;
import fpml.confirmation.LcTermination.LcTerminationImpl;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.meta.LcTerminationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing either the expiry or cancellation of a letter of credit
 * @version ${project.version}
 */
@RosettaDataType(value="LcTermination", builder=LcTermination.LcTerminationBuilderImpl.class, version="${project.version}")
public interface LcTermination extends AbstractLcEvent {

	LcTerminationMeta metaData = new LcTerminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Determines whether this event was created due to a natural expiration of the letter of credit or an unscheduled cancellation.
	 */
	Boolean getExpiry();

	/*********************** Build Methods  ***********************/
	LcTermination build();
	
	LcTermination.LcTerminationBuilder toBuilder();
	
	static LcTermination.LcTerminationBuilder builder() {
		return new LcTermination.LcTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcTermination> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LcTermination> getType() {
		return LcTermination.class;
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
		processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcTerminationBuilder extends LcTermination, AbstractLcEvent.AbstractLcEventBuilder {
		LcTermination.LcTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LcTermination.LcTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LcTermination.LcTerminationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LcTermination.LcTerminationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LcTermination.LcTerminationBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LcTermination.LcTerminationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LcTermination.LcTerminationBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LcTermination.LcTerminationBuilder setComment(String comment);
		LcTermination.LcTerminationBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		LcTermination.LcTerminationBuilder setEffectiveDate(Date effectiveDate);
		LcTermination.LcTerminationBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);
		LcTermination.LcTerminationBuilder setExpiry(Boolean expiry);

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
			processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
		}
		

		LcTermination.LcTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of LcTermination  ***********************/
	class LcTerminationImpl extends AbstractLcEvent.AbstractLcEventImpl implements LcTermination {
		private final Boolean expiry;
		
		protected LcTerminationImpl(LcTermination.LcTerminationBuilder builder) {
			super(builder);
			this.expiry = builder.getExpiry();
		}
		
		@Override
		@RosettaAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		public LcTermination build() {
			return this;
		}
		
		@Override
		public LcTermination.LcTerminationBuilder toBuilder() {
			LcTermination.LcTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcTermination.LcTerminationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpiry()).ifPresent(builder::setExpiry);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcTermination _that = getType().cast(o);
		
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcTermination {" +
				"expiry=" + this.expiry +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcTermination  ***********************/
	class LcTerminationBuilderImpl extends AbstractLcEvent.AbstractLcEventBuilderImpl  implements LcTermination.LcTerminationBuilder {
	
		protected Boolean expiry;
	
		public LcTerminationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		public LcTermination.LcTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LcTermination.LcTerminationBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LcTermination.LcTerminationBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public LcTermination.LcTerminationBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LcTermination.LcTerminationBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LcTermination.LcTerminationBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LcTermination.LcTerminationBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LcTermination.LcTerminationBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public LcTermination.LcTerminationBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public LcTermination.LcTerminationBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LcTermination.LcTerminationBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference) {
			this.letterOfCreditReference = letterOfCreditReference==null?null:letterOfCreditReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expiry")
		public LcTermination.LcTerminationBuilder setExpiry(Boolean expiry) {
			this.expiry = expiry==null?null:expiry;
			return this;
		}
		
		@Override
		public LcTermination build() {
			return new LcTermination.LcTerminationImpl(this);
		}
		
		@Override
		public LcTermination.LcTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcTermination.LcTerminationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpiry()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcTermination.LcTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LcTermination.LcTerminationBuilder o = (LcTermination.LcTerminationBuilder) other;
			
			
			merger.mergeBasic(getExpiry(), o.getExpiry(), this::setExpiry);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcTermination _that = getType().cast(o);
		
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcTerminationBuilder {" +
				"expiry=" + this.expiry +
			'}' + " " + super.toString();
		}
	}
}
