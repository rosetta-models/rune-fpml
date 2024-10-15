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
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestConfirmation;
import fpml.confirmation.RequestConfirmation.RequestConfirmationBuilder;
import fpml.confirmation.RequestConfirmation.RequestConfirmationBuilderImpl;
import fpml.confirmation.RequestConfirmation.RequestConfirmationImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestConfirmationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The confirmation process starts with the requestConfirmation message. The message may be used to request the confirmation of a new trade or any other event supported by FpML such as novation, terminations, amendments, etc. A message type defining the start of the confirmation process. The message may be used to request the confirmation of a new trade or any other event supported by FpML such as novation, terminations, amendments, etc.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestConfirmation", builder=RequestConfirmation.RequestConfirmationBuilderImpl.class, version="${project.version}")
public interface RequestConfirmation extends CorrectableRequestMessage {

	RequestConfirmationMeta metaData = new RequestConfirmationMeta();

	/*********************** Getter Methods  ***********************/
	TradingAndPostTradeEventsModel getTradingAndPostTradeEventsModel();
	/**
	 * A structure describing an option exercise event. The optionExercise event supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
	 */
	OptionExercise getOptionExercise();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestConfirmation build();
	
	RequestConfirmation.RequestConfirmationBuilder toBuilder();
	
	static RequestConfirmation.RequestConfirmationBuilder builder() {
		return new RequestConfirmation.RequestConfirmationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestConfirmation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestConfirmation> getType() {
		return RequestConfirmation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.class, getTradingAndPostTradeEventsModel());
		processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.class, getOptionExercise());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestConfirmationBuilder extends RequestConfirmation, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getOrCreateTradingAndPostTradeEventsModel();
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getTradingAndPostTradeEventsModel();
		OptionExercise.OptionExerciseBuilder getOrCreateOptionExercise();
		OptionExercise.OptionExerciseBuilder getOptionExercise();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestConfirmation.RequestConfirmationBuilder setExpectedBuild(Integer expectedBuild);
		RequestConfirmation.RequestConfirmationBuilder setActualBuild(Integer actualBuild);
		RequestConfirmation.RequestConfirmationBuilder setHeader(RequestMessageHeader header);
		RequestConfirmation.RequestConfirmationBuilder setValidationModel(ValidationModel validationModel);
		RequestConfirmation.RequestConfirmationBuilder setIsCorrection(Boolean isCorrection);
		RequestConfirmation.RequestConfirmationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestConfirmation.RequestConfirmationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestConfirmation.RequestConfirmationBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel);
		RequestConfirmation.RequestConfirmationBuilder setOptionExercise(OptionExercise optionExercise);
		RequestConfirmation.RequestConfirmationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder.class, getTradingAndPostTradeEventsModel());
			processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.OptionExerciseBuilder.class, getOptionExercise());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestConfirmation.RequestConfirmationBuilder prune();
	}

	/*********************** Immutable Implementation of RequestConfirmation  ***********************/
	class RequestConfirmationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestConfirmation {
		private final TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel;
		private final OptionExercise optionExercise;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestConfirmationImpl(RequestConfirmation.RequestConfirmationBuilder builder) {
			super(builder);
			this.tradingAndPostTradeEventsModel = ofNullable(builder.getTradingAndPostTradeEventsModel()).map(f->f.build()).orElse(null);
			this.optionExercise = ofNullable(builder.getOptionExercise()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public TradingAndPostTradeEventsModel getTradingAndPostTradeEventsModel() {
			return tradingAndPostTradeEventsModel;
		}
		
		@Override
		@RosettaAttribute("optionExercise")
		public OptionExercise getOptionExercise() {
			return optionExercise;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestConfirmation build() {
			return this;
		}
		
		@Override
		public RequestConfirmation.RequestConfirmationBuilder toBuilder() {
			RequestConfirmation.RequestConfirmationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestConfirmation.RequestConfirmationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradingAndPostTradeEventsModel()).ifPresent(builder::setTradingAndPostTradeEventsModel);
			ofNullable(getOptionExercise()).ifPresent(builder::setOptionExercise);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(tradingAndPostTradeEventsModel, _that.getTradingAndPostTradeEventsModel())) return false;
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingAndPostTradeEventsModel != null ? tradingAndPostTradeEventsModel.hashCode() : 0);
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConfirmation {" +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestConfirmation  ***********************/
	class RequestConfirmationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements RequestConfirmation.RequestConfirmationBuilder {
	
		protected TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder tradingAndPostTradeEventsModel;
		protected OptionExercise.OptionExerciseBuilder optionExercise;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestConfirmationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getTradingAndPostTradeEventsModel() {
			return tradingAndPostTradeEventsModel;
		}
		
		@Override
		public TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getOrCreateTradingAndPostTradeEventsModel() {
			TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder result;
			if (tradingAndPostTradeEventsModel!=null) {
				result = tradingAndPostTradeEventsModel;
			}
			else {
				result = tradingAndPostTradeEventsModel = TradingAndPostTradeEventsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExercise")
		public OptionExercise.OptionExerciseBuilder getOptionExercise() {
			return optionExercise;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder getOrCreateOptionExercise() {
			OptionExercise.OptionExerciseBuilder result;
			if (optionExercise!=null) {
				result = optionExercise;
			}
			else {
				result = optionExercise = OptionExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel() {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder result;
			if (partiesAndAccountsModel!=null) {
				result = partiesAndAccountsModel;
			}
			else {
				result = partiesAndAccountsModel = PartiesAndAccountsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public RequestConfirmation.RequestConfirmationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestConfirmation.RequestConfirmationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestConfirmation.RequestConfirmationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestConfirmation.RequestConfirmationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RequestConfirmation.RequestConfirmationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestConfirmation.RequestConfirmationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestConfirmation.RequestConfirmationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public RequestConfirmation.RequestConfirmationBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			this.tradingAndPostTradeEventsModel = tradingAndPostTradeEventsModel==null?null:tradingAndPostTradeEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExercise")
		public RequestConfirmation.RequestConfirmationBuilder setOptionExercise(OptionExercise optionExercise) {
			this.optionExercise = optionExercise==null?null:optionExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestConfirmation.RequestConfirmationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestConfirmation build() {
			return new RequestConfirmation.RequestConfirmationImpl(this);
		}
		
		@Override
		public RequestConfirmation.RequestConfirmationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConfirmation.RequestConfirmationBuilder prune() {
			super.prune();
			if (tradingAndPostTradeEventsModel!=null && !tradingAndPostTradeEventsModel.prune().hasData()) tradingAndPostTradeEventsModel = null;
			if (optionExercise!=null && !optionExercise.prune().hasData()) optionExercise = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradingAndPostTradeEventsModel()!=null && getTradingAndPostTradeEventsModel().hasData()) return true;
			if (getOptionExercise()!=null && getOptionExercise().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConfirmation.RequestConfirmationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestConfirmation.RequestConfirmationBuilder o = (RequestConfirmation.RequestConfirmationBuilder) other;
			
			merger.mergeRosetta(getTradingAndPostTradeEventsModel(), o.getTradingAndPostTradeEventsModel(), this::setTradingAndPostTradeEventsModel);
			merger.mergeRosetta(getOptionExercise(), o.getOptionExercise(), this::setOptionExercise);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(tradingAndPostTradeEventsModel, _that.getTradingAndPostTradeEventsModel())) return false;
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingAndPostTradeEventsModel != null ? tradingAndPostTradeEventsModel.hashCode() : 0);
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestConfirmationBuilder {" +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
