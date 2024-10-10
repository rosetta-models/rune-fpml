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
import fpml.confirmation.ConfirmationRetracted;
import fpml.confirmation.ConfirmationRetracted.ConfirmationRetractedBuilder;
import fpml.confirmation.ConfirmationRetracted.ConfirmationRetractedBuilderImpl;
import fpml.confirmation.ConfirmationRetracted.ConfirmationRetractedImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ConfirmationRetractedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message indicating that a confirmation request has been withdrawn by the submitter.
 * @version ${project.version}
 */
@RosettaDataType(value="ConfirmationRetracted", builder=ConfirmationRetracted.ConfirmationRetractedBuilderImpl.class, version="${project.version}")
public interface ConfirmationRetracted extends NonCorrectableRequestMessage {

	ConfirmationRetractedMeta metaData = new ConfirmationRetractedMeta();

	/*********************** Getter Methods  ***********************/
	TradingAndPostTradeEventsModel getTradingAndPostTradeEventsModel();
	/**
	 * A structure describing an option exercise event. The optionExercise event supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
	 */
	OptionExercise getOptionExercise();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	ConfirmationRetracted build();
	
	ConfirmationRetracted.ConfirmationRetractedBuilder toBuilder();
	
	static ConfirmationRetracted.ConfirmationRetractedBuilder builder() {
		return new ConfirmationRetracted.ConfirmationRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConfirmationRetracted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ConfirmationRetracted> getType() {
		return ConfirmationRetracted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.class, getTradingAndPostTradeEventsModel());
		processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.class, getOptionExercise());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConfirmationRetractedBuilder extends ConfirmationRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getOrCreateTradingAndPostTradeEventsModel();
		TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder getTradingAndPostTradeEventsModel();
		OptionExercise.OptionExerciseBuilder getOrCreateOptionExercise();
		OptionExercise.OptionExerciseBuilder getOptionExercise();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		ConfirmationRetracted.ConfirmationRetractedBuilder setExpectedBuild(Integer expectedBuild);
		ConfirmationRetracted.ConfirmationRetractedBuilder setActualBuild(Integer actualBuild);
		ConfirmationRetracted.ConfirmationRetractedBuilder setHeader(RequestMessageHeader header);
		ConfirmationRetracted.ConfirmationRetractedBuilder setValidationModel(ValidationModel validationModel);
		ConfirmationRetracted.ConfirmationRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		ConfirmationRetracted.ConfirmationRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ConfirmationRetracted.ConfirmationRetractedBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel);
		ConfirmationRetracted.ConfirmationRetractedBuilder setOptionExercise(OptionExercise optionExercise);
		ConfirmationRetracted.ConfirmationRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradingAndPostTradeEventsModel"), processor, TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder.class, getTradingAndPostTradeEventsModel());
			processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.OptionExerciseBuilder.class, getOptionExercise());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		ConfirmationRetracted.ConfirmationRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of ConfirmationRetracted  ***********************/
	class ConfirmationRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements ConfirmationRetracted {
		private final TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel;
		private final OptionExercise optionExercise;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected ConfirmationRetractedImpl(ConfirmationRetracted.ConfirmationRetractedBuilder builder) {
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
		public ConfirmationRetracted build() {
			return this;
		}
		
		@Override
		public ConfirmationRetracted.ConfirmationRetractedBuilder toBuilder() {
			ConfirmationRetracted.ConfirmationRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConfirmationRetracted.ConfirmationRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradingAndPostTradeEventsModel()).ifPresent(builder::setTradingAndPostTradeEventsModel);
			ofNullable(getOptionExercise()).ifPresent(builder::setOptionExercise);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConfirmationRetracted _that = getType().cast(o);
		
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
			return "ConfirmationRetracted {" +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConfirmationRetracted  ***********************/
	class ConfirmationRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements ConfirmationRetracted.ConfirmationRetractedBuilder {
	
		protected TradingAndPostTradeEventsModel.TradingAndPostTradeEventsModelBuilder tradingAndPostTradeEventsModel;
		protected OptionExercise.OptionExerciseBuilder optionExercise;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public ConfirmationRetractedBuilderImpl() {
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
		public ConfirmationRetracted.ConfirmationRetractedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ConfirmationRetracted.ConfirmationRetractedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ConfirmationRetracted.ConfirmationRetractedBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ConfirmationRetracted.ConfirmationRetractedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public ConfirmationRetracted.ConfirmationRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ConfirmationRetracted.ConfirmationRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public ConfirmationRetracted.ConfirmationRetractedBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			this.tradingAndPostTradeEventsModel = tradingAndPostTradeEventsModel==null?null:tradingAndPostTradeEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExercise")
		public ConfirmationRetracted.ConfirmationRetractedBuilder setOptionExercise(OptionExercise optionExercise) {
			this.optionExercise = optionExercise==null?null:optionExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ConfirmationRetracted.ConfirmationRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public ConfirmationRetracted build() {
			return new ConfirmationRetracted.ConfirmationRetractedImpl(this);
		}
		
		@Override
		public ConfirmationRetracted.ConfirmationRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConfirmationRetracted.ConfirmationRetractedBuilder prune() {
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
		public ConfirmationRetracted.ConfirmationRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ConfirmationRetracted.ConfirmationRetractedBuilder o = (ConfirmationRetracted.ConfirmationRetractedBuilder) other;
			
			merger.mergeRosetta(getTradingAndPostTradeEventsModel(), o.getTradingAndPostTradeEventsModel(), this::setTradingAndPostTradeEventsModel);
			merger.mergeRosetta(getOptionExercise(), o.getOptionExercise(), this::setOptionExercise);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConfirmationRetracted _that = getType().cast(o);
		
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
			return "ConfirmationRetractedBuilder {" +
				"tradingAndPostTradeEventsModel=" + this.tradingAndPostTradeEventsModel + ", " +
				"optionExercise=" + this.optionExercise + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
