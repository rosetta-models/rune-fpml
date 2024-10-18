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
import fpml.confirmation.AbstractLoanTradeEvent;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl;
import fpml.confirmation.AbstractLoanTradeEvent.AbstractLoanTradeEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.LoanTradeEvent;
import fpml.confirmation.LoanTradeEvent.LoanTradeEventBuilder;
import fpml.confirmation.LoanTradeEvent.LoanTradeEventBuilderImpl;
import fpml.confirmation.LoanTradeEvent.LoanTradeEventImpl;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.meta.LoanTradeEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * An event structure defining counterparty-to-counterparty loan trade information. This structure contains the main (e.g. fund manager/main counterparty) trade details.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradeEvent", builder=LoanTradeEvent.LoanTradeEventBuilderImpl.class, version="${project.version}")
public interface LoanTradeEvent extends AbstractLoanTradeEvent {

	LoanTradeEventMeta metaData = new LoanTradeEventMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	LoanTradeEvent build();
	
	LoanTradeEvent.LoanTradeEventBuilder toBuilder();
	
	static LoanTradeEvent.LoanTradeEventBuilder builder() {
		return new LoanTradeEvent.LoanTradeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeEvent> getType() {
		return LoanTradeEvent.class;
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
	interface LoanTradeEventBuilder extends LoanTradeEvent, AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder {
		LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanTradeEvent.LoanTradeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanTradeEvent.LoanTradeEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanTradeEvent.LoanTradeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanTradeEvent.LoanTradeEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanTradeEvent.LoanTradeEventBuilder setComment(String comment);
		LoanTradeEvent.LoanTradeEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
		}
		

		LoanTradeEvent.LoanTradeEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeEvent  ***********************/
	class LoanTradeEventImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventImpl implements LoanTradeEvent {
		
		protected LoanTradeEventImpl(LoanTradeEvent.LoanTradeEventBuilder builder) {
			super(builder);
		}
		
		@Override
		public LoanTradeEvent build() {
			return this;
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder toBuilder() {
			LoanTradeEvent.LoanTradeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeEvent.LoanTradeEventBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeEvent {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeEvent  ***********************/
	class LoanTradeEventBuilderImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl  implements LoanTradeEvent.LoanTradeEventBuilder {
	
	
		public LoanTradeEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeEvent.LoanTradeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeEvent.LoanTradeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeEvent.LoanTradeEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanTradeEvent.LoanTradeEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanTradeEvent.LoanTradeEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanTradeEvent.LoanTradeEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeEvent.LoanTradeEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference) {
			this.loanTradeReference = loanTradeReference==null?null:loanTradeReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeEvent build() {
			return new LoanTradeEvent.LoanTradeEventImpl(this);
		}
		
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeEvent.LoanTradeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeEvent.LoanTradeEventBuilder o = (LoanTradeEvent.LoanTradeEventBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeEventBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
