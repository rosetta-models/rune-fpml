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
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestConfirmationRetracted;
import fpml.confirmation.RequestConfirmationRetracted.RequestConfirmationRetractedBuilder;
import fpml.confirmation.RequestConfirmationRetracted.RequestConfirmationRetractedBuilderImpl;
import fpml.confirmation.RequestConfirmationRetracted.RequestConfirmationRetractedImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestConfirmationRetractedMeta;


/**
 * A requestConfirmation message may be cancelled using the requestConfirmationRetracted message.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestConfirmationRetracted", builder=RequestConfirmationRetracted.RequestConfirmationRetractedBuilderImpl.class, version="${project.version}")
public interface RequestConfirmationRetracted extends ConfirmationRetracted {

	RequestConfirmationRetractedMeta metaData = new RequestConfirmationRetractedMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RequestConfirmationRetracted build();
	
	RequestConfirmationRetracted.RequestConfirmationRetractedBuilder toBuilder();
	
	static RequestConfirmationRetracted.RequestConfirmationRetractedBuilder builder() {
		return new RequestConfirmationRetracted.RequestConfirmationRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestConfirmationRetracted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestConfirmationRetracted> getType() {
		return RequestConfirmationRetracted.class;
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
	interface RequestConfirmationRetractedBuilder extends RequestConfirmationRetracted, ConfirmationRetracted.ConfirmationRetractedBuilder {
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setExpectedBuild(Integer expectedBuild);
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setActualBuild(Integer actualBuild);
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setHeader(RequestMessageHeader header);
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setValidationModel(ValidationModel validationModel);
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel);
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOptionExercise(OptionExercise optionExercise);
		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

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
		

		RequestConfirmationRetracted.RequestConfirmationRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of RequestConfirmationRetracted  ***********************/
	class RequestConfirmationRetractedImpl extends ConfirmationRetracted.ConfirmationRetractedImpl implements RequestConfirmationRetracted {
		
		protected RequestConfirmationRetractedImpl(RequestConfirmationRetracted.RequestConfirmationRetractedBuilder builder) {
			super(builder);
		}
		
		@Override
		public RequestConfirmationRetracted build() {
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder toBuilder() {
			RequestConfirmationRetracted.RequestConfirmationRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestConfirmationRetracted.RequestConfirmationRetractedBuilder builder) {
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
			return "RequestConfirmationRetracted {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestConfirmationRetracted  ***********************/
	class RequestConfirmationRetractedBuilderImpl extends ConfirmationRetracted.ConfirmationRetractedBuilderImpl  implements RequestConfirmationRetracted.RequestConfirmationRetractedBuilder {
	
	
		public RequestConfirmationRetractedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expectedBuild")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingAndPostTradeEventsModel")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setTradingAndPostTradeEventsModel(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			this.tradingAndPostTradeEventsModel = tradingAndPostTradeEventsModel==null?null:tradingAndPostTradeEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionExercise")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setOptionExercise(OptionExercise optionExercise) {
			this.optionExercise = optionExercise==null?null:optionExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestConfirmationRetracted build() {
			return new RequestConfirmationRetracted.RequestConfirmationRetractedImpl(this);
		}
		
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder prune() {
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
		public RequestConfirmationRetracted.RequestConfirmationRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestConfirmationRetracted.RequestConfirmationRetractedBuilder o = (RequestConfirmationRetracted.RequestConfirmationRetractedBuilder) other;
			
			
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
			return "RequestConfirmationRetractedBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
