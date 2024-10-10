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
import fpml.confirmation.RequestExecution;
import fpml.confirmation.RequestExecution.RequestExecutionBuilder;
import fpml.confirmation.RequestExecution.RequestExecutionBuilderImpl;
import fpml.confirmation.RequestExecution.RequestExecutionImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestExecutionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message requesting that an order be executed.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestExecution", builder=RequestExecution.RequestExecutionBuilderImpl.class, version="${project.version}")
public interface RequestExecution extends CorrectableRequestMessage {

	RequestExecutionMeta metaData = new RequestExecutionMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsModel getTradingEventsModel();
	/**
	 * A structure describing an option exercise event. The optionExercise event supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
	 */
	OptionExercise getOptionExercise();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestExecution build();
	
	RequestExecution.RequestExecutionBuilder toBuilder();
	
	static RequestExecution.RequestExecutionBuilder builder() {
		return new RequestExecution.RequestExecutionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestExecution> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestExecution> getType() {
		return RequestExecution.class;
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
		processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.class, getTradingEventsModel());
		processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.class, getOptionExercise());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestExecutionBuilder extends RequestExecution, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel();
		TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel();
		OptionExercise.OptionExerciseBuilder getOrCreateOptionExercise();
		OptionExercise.OptionExerciseBuilder getOptionExercise();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestExecution.RequestExecutionBuilder setExpectedBuild(Integer expectedBuild);
		RequestExecution.RequestExecutionBuilder setActualBuild(Integer actualBuild);
		RequestExecution.RequestExecutionBuilder setHeader(RequestMessageHeader header);
		RequestExecution.RequestExecutionBuilder setValidationModel(ValidationModel validationModel);
		RequestExecution.RequestExecutionBuilder setIsCorrection(Boolean isCorrection);
		RequestExecution.RequestExecutionBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestExecution.RequestExecutionBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestExecution.RequestExecutionBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel);
		RequestExecution.RequestExecutionBuilder setOptionExercise(OptionExercise optionExercise);
		RequestExecution.RequestExecutionBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.TradingEventsModelBuilder.class, getTradingEventsModel());
			processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.OptionExerciseBuilder.class, getOptionExercise());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestExecution.RequestExecutionBuilder prune();
	}

	/*********************** Immutable Implementation of RequestExecution  ***********************/
	class RequestExecutionImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestExecution {
		private final TradingEventsModel tradingEventsModel;
		private final OptionExercise optionExercise;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestExecutionImpl(RequestExecution.RequestExecutionBuilder builder) {
			super(builder);
			this.tradingEventsModel = ofNullable(builder.getTradingEventsModel()).map(f->f.build()).orElse(null);
			this.optionExercise = ofNullable(builder.getOptionExercise()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel getTradingEventsModel() {
			return tradingEventsModel;
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
		public RequestExecution build() {
			return this;
		}
		
		@Override
		public RequestExecution.RequestExecutionBuilder toBuilder() {
			RequestExecution.RequestExecutionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestExecution.RequestExecutionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradingEventsModel()).ifPresent(builder::setTradingEventsModel);
			ofNullable(getOptionExercise()).ifPresent(builder::setOptionExercise);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestExecution _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestExecution {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestExecution  ***********************/
	class RequestExecutionBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements RequestExecution.RequestExecutionBuilder {
	
		protected TradingEventsModel.TradingEventsModelBuilder tradingEventsModel;
		protected OptionExercise.OptionExerciseBuilder optionExercise;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestExecutionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		public TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel() {
			TradingEventsModel.TradingEventsModelBuilder result;
			if (tradingEventsModel!=null) {
				result = tradingEventsModel;
			}
			else {
				result = tradingEventsModel = TradingEventsModel.builder();
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
		public RequestExecution.RequestExecutionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestExecution.RequestExecutionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestExecution.RequestExecutionBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestExecution.RequestExecutionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RequestExecution.RequestExecutionBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestExecution.RequestExecutionBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestExecution.RequestExecutionBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsModel")
		public RequestExecution.RequestExecutionBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel) {
			this.tradingEventsModel = tradingEventsModel==null?null:tradingEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExercise")
		public RequestExecution.RequestExecutionBuilder setOptionExercise(OptionExercise optionExercise) {
			this.optionExercise = optionExercise==null?null:optionExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestExecution.RequestExecutionBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestExecution build() {
			return new RequestExecution.RequestExecutionImpl(this);
		}
		
		@Override
		public RequestExecution.RequestExecutionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestExecution.RequestExecutionBuilder prune() {
			super.prune();
			if (tradingEventsModel!=null && !tradingEventsModel.prune().hasData()) tradingEventsModel = null;
			if (optionExercise!=null && !optionExercise.prune().hasData()) optionExercise = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradingEventsModel()!=null && getTradingEventsModel().hasData()) return true;
			if (getOptionExercise()!=null && getOptionExercise().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestExecution.RequestExecutionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestExecution.RequestExecutionBuilder o = (RequestExecution.RequestExecutionBuilder) other;
			
			merger.mergeRosetta(getTradingEventsModel(), o.getTradingEventsModel(), this::setTradingEventsModel);
			merger.mergeRosetta(getOptionExercise(), o.getOptionExercise(), this::setOptionExercise);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestExecution _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestExecutionBuilder {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
