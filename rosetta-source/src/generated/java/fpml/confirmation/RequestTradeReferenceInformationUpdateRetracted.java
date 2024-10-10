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
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestTradeReferenceInformationUpdateRetracted;
import fpml.confirmation.RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder;
import fpml.confirmation.RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilderImpl;
import fpml.confirmation.RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedImpl;
import fpml.confirmation.TradeReferenceInformationModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestTradeReferenceInformationUpdateRetractedMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the structure for a message retracting a request to updated information about trade.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestTradeReferenceInformationUpdateRetracted", builder=RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilderImpl.class, version="${project.version}")
public interface RequestTradeReferenceInformationUpdateRetracted extends NonCorrectableRequestMessage {

	RequestTradeReferenceInformationUpdateRetractedMeta metaData = new RequestTradeReferenceInformationUpdateRetractedMeta();

	/*********************** Getter Methods  ***********************/
	TradeReferenceInformationModel getTradeReferenceInformationModel();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestTradeReferenceInformationUpdateRetracted build();
	
	RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder toBuilder();
	
	static RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder builder() {
		return new RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestTradeReferenceInformationUpdateRetracted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestTradeReferenceInformationUpdateRetracted> getType() {
		return RequestTradeReferenceInformationUpdateRetracted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.class, getTradeReferenceInformationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestTradeReferenceInformationUpdateRetractedBuilder extends RequestTradeReferenceInformationUpdateRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getOrCreateTradeReferenceInformationModel();
		TradeReferenceInformationModel.TradeReferenceInformationModelBuilder getTradeReferenceInformationModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setExpectedBuild(Integer expectedBuild);
		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setActualBuild(Integer actualBuild);
		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setHeader(RequestMessageHeader header);
		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setValidationModel(ValidationModel validationModel);
		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel);
		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradeReferenceInformationModel"), processor, TradeReferenceInformationModel.TradeReferenceInformationModelBuilder.class, getTradeReferenceInformationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of RequestTradeReferenceInformationUpdateRetracted  ***********************/
	class RequestTradeReferenceInformationUpdateRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements RequestTradeReferenceInformationUpdateRetracted {
		private final TradeReferenceInformationModel tradeReferenceInformationModel;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestTradeReferenceInformationUpdateRetractedImpl(RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder builder) {
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
		public RequestTradeReferenceInformationUpdateRetracted build() {
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder toBuilder() {
			RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeReferenceInformationModel()).ifPresent(builder::setTradeReferenceInformationModel);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestTradeReferenceInformationUpdateRetracted _that = getType().cast(o);
		
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
			return "RequestTradeReferenceInformationUpdateRetracted {" +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestTradeReferenceInformationUpdateRetracted  ***********************/
	class RequestTradeReferenceInformationUpdateRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder {
	
		protected TradeReferenceInformationModel.TradeReferenceInformationModelBuilder tradeReferenceInformationModel;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestTradeReferenceInformationUpdateRetractedBuilderImpl() {
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
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradeReferenceInformationModel")
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setTradeReferenceInformationModel(TradeReferenceInformationModel tradeReferenceInformationModel) {
			this.tradeReferenceInformationModel = tradeReferenceInformationModel==null?null:tradeReferenceInformationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestTradeReferenceInformationUpdateRetracted build() {
			return new RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedImpl(this);
		}
		
		@Override
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder prune() {
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
		public RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder o = (RequestTradeReferenceInformationUpdateRetracted.RequestTradeReferenceInformationUpdateRetractedBuilder) other;
			
			merger.mergeRosetta(getTradeReferenceInformationModel(), o.getTradeReferenceInformationModel(), this::setTradeReferenceInformationModel);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestTradeReferenceInformationUpdateRetracted _that = getType().cast(o);
		
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
			return "RequestTradeReferenceInformationUpdateRetractedBuilder {" +
				"tradeReferenceInformationModel=" + this.tradeReferenceInformationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
