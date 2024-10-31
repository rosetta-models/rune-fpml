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
import fpml.confirmation.AbstractLoanServicingEvent;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl;
import fpml.confirmation.AbstractLoanServicingEvent.AbstractLoanServicingEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.meta.AbstractLcEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base type for all LC-level business events.
 * @version ${project.version}
 */
@RosettaDataType(value="AbstractLcEvent", builder=AbstractLcEvent.AbstractLcEventBuilderImpl.class, version="${project.version}")
public interface AbstractLcEvent extends AbstractLoanServicingEvent {

	AbstractLcEventMeta metaData = new AbstractLcEventMeta();

	/*********************** Getter Methods  ***********************/
	LetterOfCreditReference getLetterOfCreditReference();

	/*********************** Build Methods  ***********************/
	AbstractLcEvent build();
	
	AbstractLcEvent.AbstractLcEventBuilder toBuilder();
	
	static AbstractLcEvent.AbstractLcEventBuilder builder() {
		return new AbstractLcEvent.AbstractLcEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLcEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLcEvent> getType() {
		return AbstractLcEvent.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLcEventBuilder extends AbstractLcEvent, AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder {
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference();
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference();
		AbstractLcEvent.AbstractLcEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractLcEvent.AbstractLcEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractLcEvent.AbstractLcEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractLcEvent.AbstractLcEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AbstractLcEvent.AbstractLcEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AbstractLcEvent.AbstractLcEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractLcEvent.AbstractLcEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AbstractLcEvent.AbstractLcEventBuilder setComment(String comment);
		AbstractLcEvent.AbstractLcEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		AbstractLcEvent.AbstractLcEventBuilder setEffectiveDate(Date effectiveDate);
		AbstractLcEvent.AbstractLcEventBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);

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
		}
		

		AbstractLcEvent.AbstractLcEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLcEvent  ***********************/
	class AbstractLcEventImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventImpl implements AbstractLcEvent {
		private final LetterOfCreditReference letterOfCreditReference;
		
		protected AbstractLcEventImpl(AbstractLcEvent.AbstractLcEventBuilder builder) {
			super(builder);
			this.letterOfCreditReference = ofNullable(builder.getLetterOfCreditReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LetterOfCreditReference getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public AbstractLcEvent build() {
			return this;
		}
		
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder toBuilder() {
			AbstractLcEvent.AbstractLcEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLcEvent.AbstractLcEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLetterOfCreditReference()).ifPresent(builder::setLetterOfCreditReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLcEvent _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLcEvent {" +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLcEvent  ***********************/
	class AbstractLcEventBuilderImpl extends AbstractLoanServicingEvent.AbstractLoanServicingEventBuilderImpl  implements AbstractLcEvent.AbstractLcEventBuilder {
	
		protected LetterOfCreditReference.LetterOfCreditReferenceBuilder letterOfCreditReference;
	
		public AbstractLcEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference() {
			LetterOfCreditReference.LetterOfCreditReferenceBuilder result;
			if (letterOfCreditReference!=null) {
				result = letterOfCreditReference;
			}
			else {
				result = letterOfCreditReference = LetterOfCreditReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public AbstractLcEvent.AbstractLcEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractLcEvent.AbstractLcEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractLcEvent.AbstractLcEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLcEvent.AbstractLcEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AbstractLcEvent.AbstractLcEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AbstractLcEvent.AbstractLcEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLcEvent.AbstractLcEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public AbstractLcEvent.AbstractLcEventBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public AbstractLcEvent.AbstractLcEventBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("letterOfCreditReference")
		public AbstractLcEvent.AbstractLcEventBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference) {
			this.letterOfCreditReference = letterOfCreditReference==null?null:letterOfCreditReference.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLcEvent build() {
			return new AbstractLcEvent.AbstractLcEventImpl(this);
		}
		
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder prune() {
			super.prune();
			if (letterOfCreditReference!=null && !letterOfCreditReference.prune().hasData()) letterOfCreditReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLetterOfCreditReference()!=null && getLetterOfCreditReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLcEvent.AbstractLcEventBuilder o = (AbstractLcEvent.AbstractLcEventBuilder) other;
			
			merger.mergeRosetta(getLetterOfCreditReference(), o.getLetterOfCreditReference(), this::setLetterOfCreditReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLcEvent _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLcEventBuilder {" +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}' + " " + super.toString();
		}
	}
}
