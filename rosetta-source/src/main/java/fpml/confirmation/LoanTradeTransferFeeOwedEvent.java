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
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.LoanTradeTransferFeeOwedEvent;
import fpml.confirmation.LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder;
import fpml.confirmation.LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilderImpl;
import fpml.confirmation.LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventImpl;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel;
import fpml.confirmation.meta.LoanTradeTransferFeeOwedEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines details related to the admin agent&#39;s determination of transfer fee(s) owed on an allocation.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanTradeTransferFeeOwedEvent", builder=LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilderImpl.class, version="${project.version}")
public interface LoanTradeTransferFeeOwedEvent extends AbstractLoanTradeEvent {

	LoanTradeTransferFeeOwedEventMeta metaData = new LoanTradeTransferFeeOwedEventMeta();

	/*********************** Getter Methods  ***********************/
	LoanTradingTransferFeeDeterminationModel getLoanTradingTransferFeeDeterminationModel();

	/*********************** Build Methods  ***********************/
	LoanTradeTransferFeeOwedEvent build();
	
	LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder toBuilder();
	
	static LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder builder() {
		return new LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeTransferFeeOwedEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanTradeTransferFeeOwedEvent> getType() {
		return LoanTradeTransferFeeOwedEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.class, getLoanTradeReference());
		processRosetta(path.newSubPath("loanTradingTransferFeeDeterminationModel"), processor, LoanTradingTransferFeeDeterminationModel.class, getLoanTradingTransferFeeDeterminationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeTransferFeeOwedEventBuilder extends LoanTradeTransferFeeOwedEvent, AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder {
		LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder getOrCreateLoanTradingTransferFeeDeterminationModel();
		LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder getLoanTradingTransferFeeDeterminationModel();
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setComment(String comment);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference);
		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setLoanTradingTransferFeeDeterminationModel(LoanTradingTransferFeeDeterminationModel loanTradingTransferFeeDeterminationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("loanTradeReference"), processor, LoanTradeReference.LoanTradeReferenceBuilder.class, getLoanTradeReference());
			processRosetta(path.newSubPath("loanTradingTransferFeeDeterminationModel"), processor, LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder.class, getLoanTradingTransferFeeDeterminationModel());
		}
		

		LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeTransferFeeOwedEvent  ***********************/
	class LoanTradeTransferFeeOwedEventImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventImpl implements LoanTradeTransferFeeOwedEvent {
		private final LoanTradingTransferFeeDeterminationModel loanTradingTransferFeeDeterminationModel;
		
		protected LoanTradeTransferFeeOwedEventImpl(LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder builder) {
			super(builder);
			this.loanTradingTransferFeeDeterminationModel = ofNullable(builder.getLoanTradingTransferFeeDeterminationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradingTransferFeeDeterminationModel")
		public LoanTradingTransferFeeDeterminationModel getLoanTradingTransferFeeDeterminationModel() {
			return loanTradingTransferFeeDeterminationModel;
		}
		
		@Override
		public LoanTradeTransferFeeOwedEvent build() {
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder toBuilder() {
			LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradingTransferFeeDeterminationModel()).ifPresent(builder::setLoanTradingTransferFeeDeterminationModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeOwedEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanTradingTransferFeeDeterminationModel, _that.getLoanTradingTransferFeeDeterminationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradingTransferFeeDeterminationModel != null ? loanTradingTransferFeeDeterminationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTransferFeeOwedEvent {" +
				"loanTradingTransferFeeDeterminationModel=" + this.loanTradingTransferFeeDeterminationModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeTransferFeeOwedEvent  ***********************/
	class LoanTradeTransferFeeOwedEventBuilderImpl extends AbstractLoanTradeEvent.AbstractLoanTradeEventBuilderImpl  implements LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder {
	
		protected LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder loanTradingTransferFeeDeterminationModel;
	
		public LoanTradeTransferFeeOwedEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("loanTradingTransferFeeDeterminationModel")
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder getLoanTradingTransferFeeDeterminationModel() {
			return loanTradingTransferFeeDeterminationModel;
		}
		
		@Override
		public LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder getOrCreateLoanTradingTransferFeeDeterminationModel() {
			LoanTradingTransferFeeDeterminationModel.LoanTradingTransferFeeDeterminationModelBuilder result;
			if (loanTradingTransferFeeDeterminationModel!=null) {
				result = loanTradingTransferFeeDeterminationModel;
			}
			else {
				result = loanTradingTransferFeeDeterminationModel = LoanTradingTransferFeeDeterminationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("loanTradeReference")
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setLoanTradeReference(LoanTradeReference loanTradeReference) {
			this.loanTradeReference = loanTradeReference==null?null:loanTradeReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("loanTradingTransferFeeDeterminationModel")
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder setLoanTradingTransferFeeDeterminationModel(LoanTradingTransferFeeDeterminationModel loanTradingTransferFeeDeterminationModel) {
			this.loanTradingTransferFeeDeterminationModel = loanTradingTransferFeeDeterminationModel==null?null:loanTradingTransferFeeDeterminationModel.toBuilder();
			return this;
		}
		
		@Override
		public LoanTradeTransferFeeOwedEvent build() {
			return new LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventImpl(this);
		}
		
		@Override
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder prune() {
			super.prune();
			if (loanTradingTransferFeeDeterminationModel!=null && !loanTradingTransferFeeDeterminationModel.prune().hasData()) loanTradingTransferFeeDeterminationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradingTransferFeeDeterminationModel()!=null && getLoanTradingTransferFeeDeterminationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder o = (LoanTradeTransferFeeOwedEvent.LoanTradeTransferFeeOwedEventBuilder) other;
			
			merger.mergeRosetta(getLoanTradingTransferFeeDeterminationModel(), o.getLoanTradingTransferFeeDeterminationModel(), this::setLoanTradingTransferFeeDeterminationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeTransferFeeOwedEvent _that = getType().cast(o);
		
			if (!Objects.equals(loanTradingTransferFeeDeterminationModel, _that.getLoanTradingTransferFeeDeterminationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradingTransferFeeDeterminationModel != null ? loanTradingTransferFeeDeterminationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeTransferFeeOwedEventBuilder {" +
				"loanTradingTransferFeeDeterminationModel=" + this.loanTradingTransferFeeDeterminationModel +
			'}' + " " + super.toString();
		}
	}
}
