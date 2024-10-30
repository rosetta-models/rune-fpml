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
import fpml.confirmation.AbstractLoanEvent;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilder;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventBuilderImpl;
import fpml.confirmation.AbstractLoanEvent.AbstractLoanEventImpl;
import fpml.confirmation.AbstractLoanTradeEvent;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.meta.AbstractLoanTradeEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract structure defining fundamental master loan trade event information.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AbstractLoanTradeEvent", builder=AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AbstractLoanTradeEvent extends AbstractLoanEvent {

	AbstractLoanTradeEventMeta metaData = new AbstractLoanTradeEventMeta();

	/*********************** Getter Methods  ***********************/
	LoanTradeReference getLoanTradeReference();

	/*********************** Build Methods  ***********************/
	AbstractLoanTradeEvent build();
	
	AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder toBuilder();
	
	static AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder builder() {
		return new AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractLoanTradeEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbstractLoanTradeEvent> getType() {
		return AbstractLoanTradeEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractLoanTradeEventBuilder extends AbstractLoanTradeEvent, AbstractLoanEvent.AbstractLoanEventBuilder {
		LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference();
		LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference();
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setComment(String comment);
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
		}
		

		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractLoanTradeEvent  ***********************/
	class AbstractLoanTradeEventImpl extends AbstractLoanEvent.AbstractLoanEventImpl implements AbstractLoanTradeEvent {
		private final LoanTradeReference loanTradeReference;
		
		protected AbstractLoanTradeEventImpl(AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder builder) {
			super(builder);
			this.loanTradeReference = ofNullable(builder.getLoanTradeReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeReference getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public AbstractLoanTradeEvent build() {
			return this;
		}
		
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder toBuilder() {
			AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradeReference()).ifPresent(builder::setLoanTradeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTradeEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradeEvent {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AbstractLoanTradeEvent  ***********************/
	class AbstractLoanTradeEventBuilderImpl extends AbstractLoanEvent.AbstractLoanEventBuilderImpl  implements AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder {
	
		protected LoanTradeReference.LoanTradeReferenceBuilder loanTradeReference;
	
		public AbstractLoanTradeEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeReference.LoanTradeReferenceBuilder getLoanTradeReference() {
			return loanTradeReference;
		}
		
		@Override
		public LoanTradeReference.LoanTradeReferenceBuilder getOrCreateLoanTradeReference() {
			LoanTradeReference.LoanTradeReferenceBuilder result;
			if (loanTradeReference!=null) {
				result = loanTradeReference;
			}
			else {
				result = loanTradeReference = LoanTradeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradeReference")
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference) {
			this.loanTradeReference = loanTradeReference==null?null:loanTradeReference.toBuilder();
			return this;
		}
		
		@Override
		public AbstractLoanTradeEvent build() {
			return new AbstractLoanTradeEvent.AbstractLoanTradeEventImpl(this);
		}
		
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder prune() {
			super.prune();
			if (loanTradeReference!=null && !loanTradeReference.prune().hasData()) loanTradeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradeReference()!=null && getLoanTradeReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder o = (AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder) other;
			
			merger.mergeRosetta(getLoanTradeReference(), o.getLoanTradeReference(), this::setLoanTradeReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AbstractLoanTradeEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeReference, _that.getLoanTradeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeReference != null ? loanTradeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractLoanTradeEventBuilder {" +
				"loanTradeReference=" + this.loanTradeReference +
			'}' + " " + super.toString();
		}
	}
}
