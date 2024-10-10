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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.DeClear;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestClearingRetracted;
import fpml.confirmation.RequestClearingRetracted.RequestClearingRetractedBuilder;
import fpml.confirmation.RequestClearingRetracted.RequestClearingRetractedBuilderImpl;
import fpml.confirmation.RequestClearingRetracted.RequestClearingRetractedImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestClearingRetractedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message withdrawing a request that a trade be cleared by a clearing service.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestClearingRetracted", builder=RequestClearingRetracted.RequestClearingRetractedBuilderImpl.class, version="${project.version}")
public interface RequestClearingRetracted extends NonCorrectableRequestMessage {

	RequestClearingRetractedMeta metaData = new RequestClearingRetractedMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsModel getTradingEventsModel();
	/**
	 * A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 */
	DeClear getDeClear();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestClearingRetracted build();
	
	RequestClearingRetracted.RequestClearingRetractedBuilder toBuilder();
	
	static RequestClearingRetracted.RequestClearingRetractedBuilder builder() {
		return new RequestClearingRetracted.RequestClearingRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestClearingRetracted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestClearingRetracted> getType() {
		return RequestClearingRetracted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.class, getTradingEventsModel());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestClearingRetractedBuilder extends RequestClearingRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel();
		TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel();
		DeClear.DeClearBuilder getOrCreateDeClear();
		DeClear.DeClearBuilder getDeClear();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestClearingRetracted.RequestClearingRetractedBuilder setExpectedBuild(Integer expectedBuild);
		RequestClearingRetracted.RequestClearingRetractedBuilder setActualBuild(Integer actualBuild);
		RequestClearingRetracted.RequestClearingRetractedBuilder setHeader(RequestMessageHeader header);
		RequestClearingRetracted.RequestClearingRetractedBuilder setValidationModel(ValidationModel validationModel);
		RequestClearingRetracted.RequestClearingRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestClearingRetracted.RequestClearingRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestClearingRetracted.RequestClearingRetractedBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel);
		RequestClearingRetracted.RequestClearingRetractedBuilder setDeClear(DeClear deClear);
		RequestClearingRetracted.RequestClearingRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.TradingEventsModelBuilder.class, getTradingEventsModel());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestClearingRetracted.RequestClearingRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of RequestClearingRetracted  ***********************/
	class RequestClearingRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements RequestClearingRetracted {
		private final TradingEventsModel tradingEventsModel;
		private final DeClear deClear;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestClearingRetractedImpl(RequestClearingRetracted.RequestClearingRetractedBuilder builder) {
			super(builder);
			this.tradingEventsModel = ofNullable(builder.getTradingEventsModel()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		@RosettaAttribute("deClear")
		public DeClear getDeClear() {
			return deClear;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestClearingRetracted build() {
			return this;
		}
		
		@Override
		public RequestClearingRetracted.RequestClearingRetractedBuilder toBuilder() {
			RequestClearingRetracted.RequestClearingRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestClearingRetracted.RequestClearingRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradingEventsModel()).ifPresent(builder::setTradingEventsModel);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestClearingRetracted _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestClearingRetracted {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestClearingRetracted  ***********************/
	class RequestClearingRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements RequestClearingRetracted.RequestClearingRetractedBuilder {
	
		protected TradingEventsModel.TradingEventsModelBuilder tradingEventsModel;
		protected DeClear.DeClearBuilder deClear;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestClearingRetractedBuilderImpl() {
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
		@RosettaAttribute("deClear")
		public DeClear.DeClearBuilder getDeClear() {
			return deClear;
		}
		
		@Override
		public DeClear.DeClearBuilder getOrCreateDeClear() {
			DeClear.DeClearBuilder result;
			if (deClear!=null) {
				result = deClear;
			}
			else {
				result = deClear = DeClear.builder();
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
		public RequestClearingRetracted.RequestClearingRetractedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestClearingRetracted.RequestClearingRetractedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestClearingRetracted.RequestClearingRetractedBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestClearingRetracted.RequestClearingRetractedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestClearingRetracted.RequestClearingRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestClearingRetracted.RequestClearingRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsModel")
		public RequestClearingRetracted.RequestClearingRetractedBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel) {
			this.tradingEventsModel = tradingEventsModel==null?null:tradingEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deClear")
		public RequestClearingRetracted.RequestClearingRetractedBuilder setDeClear(DeClear deClear) {
			this.deClear = deClear==null?null:deClear.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestClearingRetracted.RequestClearingRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestClearingRetracted build() {
			return new RequestClearingRetracted.RequestClearingRetractedImpl(this);
		}
		
		@Override
		public RequestClearingRetracted.RequestClearingRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestClearingRetracted.RequestClearingRetractedBuilder prune() {
			super.prune();
			if (tradingEventsModel!=null && !tradingEventsModel.prune().hasData()) tradingEventsModel = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradingEventsModel()!=null && getTradingEventsModel().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestClearingRetracted.RequestClearingRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestClearingRetracted.RequestClearingRetractedBuilder o = (RequestClearingRetracted.RequestClearingRetractedBuilder) other;
			
			merger.mergeRosetta(getTradingEventsModel(), o.getTradingEventsModel(), this::setTradingEventsModel);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestClearingRetracted _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestClearingRetractedBuilder {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
