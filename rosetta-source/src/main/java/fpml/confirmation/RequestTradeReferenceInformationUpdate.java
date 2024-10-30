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
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestTradeReferenceInformationUpdate;
import fpml.confirmation.RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder;
import fpml.confirmation.RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilderImpl;
import fpml.confirmation.RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateImpl;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestTradeReferenceInformationUpdateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the structure for a message requesting information updates to a trade. The trade reference information should contain at least one trade identifier that the recipient is aware of.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RequestTradeReferenceInformationUpdate", builder=RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RequestTradeReferenceInformationUpdate extends CorrectableRequestMessage {

	RequestTradeReferenceInformationUpdateMeta metaData = new RequestTradeReferenceInformationUpdateMeta();

	/*********************** Getter Methods  ***********************/
	TradeReferenceInformationModel getTradeReferenceInformationModel();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestTradeReferenceInformationUpdate build();
	
	RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder toBuilder();
	
	static RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder builder() {
		return new RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestTradeReferenceInformationUpdate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestTradeReferenceInformationUpdate> getType() {
		return RequestTradeReferenceInformationUpdate.class;
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
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestTradeReferenceInformationUpdateBuilder extends RequestTradeReferenceInformationUpdate, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setExpectedBuild(Integer expectedBuild);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setActualBuild(Integer actualBuild);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setHeader(RequestMessageHeader header);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setValidationModel(ValidationModel validationModel);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setIsCorrection(Boolean isCorrection);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder prune();
	}

	/*********************** Immutable Implementation of RequestTradeReferenceInformationUpdate  ***********************/
	class RequestTradeReferenceInformationUpdateImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestTradeReferenceInformationUpdate {
		private final TradeReferenceInformationModel tradeReferenceInformationModel;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestTradeReferenceInformationUpdateImpl(RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder builder) {
			super(builder);
			this.tradeReferenceInformationModel = ofNullable(builder.getTradeReferenceInformationModel()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate build() {
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder toBuilder() {
			RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeReferenceInformationModel()).ifPresent(builder::setTradeReferenceInformationModel);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestTradeReferenceInformationUpdate _that = getType().cast(o);
		
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestTradeReferenceInformationUpdate {" +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestTradeReferenceInformationUpdate  ***********************/
	class RequestTradeReferenceInformationUpdateBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder {
	
		protected TradeReferenceInformationModel.TradeReferenceInformationModelBuilder tradeReferenceInformationModel;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestTradeReferenceInformationUpdateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel() {
			return tradeReferenceInformationModel;
		}
		
		@Override
		public TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel() {
			TradeReferenceInformationModel.TradeReferenceInformationModelBuilder result;
			if (tradeReferenceInformationModel!=null) {
				result = tradeReferenceInformationModel;
			}
			else {
				result = tradeReferenceInformationModel = TradeReferenceInformationModel.builder();
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
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate build() {
			return new RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateImpl(this);
		}
		
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder prune() {
			super.prune();
			if (tradeReferenceInformationModel!=null && !tradeReferenceInformationModel.prune().hasData()) tradeReferenceInformationModel = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeReferenceInformationModel()!=null && getTradeReferenceInformationModel().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder o = (RequestTradeReferenceInformationUpdate.RequestTradeReferenceInformationUpdateBuilder) other;
			
			merger.mergeRosetta(getTradeReferenceInformationModel(), o.getTradeReferenceInformationModel(), this::setTradeReferenceInformationModel);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestTradeReferenceInformationUpdate _that = getType().cast(o);
		
			if (!Objects.equals(tradeReferenceInformationModel, _that.getTradeReferenceInformationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeReferenceInformationModel != null ? tradeReferenceInformationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestTradeReferenceInformationUpdateBuilder {" +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
