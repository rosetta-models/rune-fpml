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
import fpml.confirmation.DeClear;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.RequestClearingEligibility;
import fpml.confirmation.RequestClearingEligibility.RequestClearingEligibilityBuilder;
import fpml.confirmation.RequestClearingEligibility.RequestClearingEligibilityBuilderImpl;
import fpml.confirmation.RequestClearingEligibility.RequestClearingEligibilityImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestClearingEligibilityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="RequestClearingEligibility", builder=RequestClearingEligibility.RequestClearingEligibilityBuilderImpl.class, version="${project.version}")
public interface RequestClearingEligibility extends CorrectableRequestMessage {

	RequestClearingEligibilityMeta metaData = new RequestClearingEligibilityMeta();

	/*********************** Getter Methods  ***********************/
	PartyReference getRequestingPartyReference();
	TradingEventsModel getTradingEventsModel();
	/**
	 * A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 */
	DeClear getDeClear();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestClearingEligibility build();
	
	RequestClearingEligibility.RequestClearingEligibilityBuilder toBuilder();
	
	static RequestClearingEligibility.RequestClearingEligibilityBuilder builder() {
		return new RequestClearingEligibility.RequestClearingEligibilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestClearingEligibility> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestClearingEligibility> getType() {
		return RequestClearingEligibility.class;
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
		processRosetta(path.newSubPath("requestingPartyReference"), processor, PartyReference.class, getRequestingPartyReference());
		processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.class, getTradingEventsModel());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestClearingEligibilityBuilder extends RequestClearingEligibility, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateRequestingPartyReference();
		PartyReference.PartyReferenceBuilder getRequestingPartyReference();
		TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel();
		TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel();
		DeClear.DeClearBuilder getOrCreateDeClear();
		DeClear.DeClearBuilder getDeClear();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestClearingEligibility.RequestClearingEligibilityBuilder setExpectedBuild(Integer expectedBuild);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setActualBuild(Integer actualBuild);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setHeader(RequestMessageHeader header);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setValidationModel(ValidationModel validationModel);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setIsCorrection(Boolean isCorrection);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setRequestingPartyReference(PartyReference requestingPartyReference);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setDeClear(DeClear deClear);
		RequestClearingEligibility.RequestClearingEligibilityBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("requestingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getRequestingPartyReference());
			processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.TradingEventsModelBuilder.class, getTradingEventsModel());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestClearingEligibility.RequestClearingEligibilityBuilder prune();
	}

	/*********************** Immutable Implementation of RequestClearingEligibility  ***********************/
	class RequestClearingEligibilityImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestClearingEligibility {
		private final PartyReference requestingPartyReference;
		private final TradingEventsModel tradingEventsModel;
		private final DeClear deClear;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestClearingEligibilityImpl(RequestClearingEligibility.RequestClearingEligibilityBuilder builder) {
			super(builder);
			this.requestingPartyReference = ofNullable(builder.getRequestingPartyReference()).map(f->f.build()).orElse(null);
			this.tradingEventsModel = ofNullable(builder.getTradingEventsModel()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("requestingPartyReference")
		public PartyReference getRequestingPartyReference() {
			return requestingPartyReference;
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
		public RequestClearingEligibility build() {
			return this;
		}
		
		@Override
		public RequestClearingEligibility.RequestClearingEligibilityBuilder toBuilder() {
			RequestClearingEligibility.RequestClearingEligibilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestClearingEligibility.RequestClearingEligibilityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRequestingPartyReference()).ifPresent(builder::setRequestingPartyReference);
			ofNullable(getTradingEventsModel()).ifPresent(builder::setTradingEventsModel);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestClearingEligibility _that = getType().cast(o);
		
			if (!Objects.equals(requestingPartyReference, _that.getRequestingPartyReference())) return false;
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (requestingPartyReference != null ? requestingPartyReference.hashCode() : 0);
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestClearingEligibility {" +
				"requestingPartyReference=" + this.requestingPartyReference + ", " +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestClearingEligibility  ***********************/
	class RequestClearingEligibilityBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements RequestClearingEligibility.RequestClearingEligibilityBuilder {
	
		protected PartyReference.PartyReferenceBuilder requestingPartyReference;
		protected TradingEventsModel.TradingEventsModelBuilder tradingEventsModel;
		protected DeClear.DeClearBuilder deClear;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestClearingEligibilityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("requestingPartyReference")
		public PartyReference.PartyReferenceBuilder getRequestingPartyReference() {
			return requestingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateRequestingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (requestingPartyReference!=null) {
				result = requestingPartyReference;
			}
			else {
				result = requestingPartyReference = PartyReference.builder();
			}
			
			return result;
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
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("requestingPartyReference")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setRequestingPartyReference(PartyReference requestingPartyReference) {
			this.requestingPartyReference = requestingPartyReference==null?null:requestingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsModel")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel) {
			this.tradingEventsModel = tradingEventsModel==null?null:tradingEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deClear")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setDeClear(DeClear deClear) {
			this.deClear = deClear==null?null:deClear.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestClearingEligibility.RequestClearingEligibilityBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestClearingEligibility build() {
			return new RequestClearingEligibility.RequestClearingEligibilityImpl(this);
		}
		
		@Override
		public RequestClearingEligibility.RequestClearingEligibilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestClearingEligibility.RequestClearingEligibilityBuilder prune() {
			super.prune();
			if (requestingPartyReference!=null && !requestingPartyReference.prune().hasData()) requestingPartyReference = null;
			if (tradingEventsModel!=null && !tradingEventsModel.prune().hasData()) tradingEventsModel = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRequestingPartyReference()!=null && getRequestingPartyReference().hasData()) return true;
			if (getTradingEventsModel()!=null && getTradingEventsModel().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestClearingEligibility.RequestClearingEligibilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestClearingEligibility.RequestClearingEligibilityBuilder o = (RequestClearingEligibility.RequestClearingEligibilityBuilder) other;
			
			merger.mergeRosetta(getRequestingPartyReference(), o.getRequestingPartyReference(), this::setRequestingPartyReference);
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
		
			RequestClearingEligibility _that = getType().cast(o);
		
			if (!Objects.equals(requestingPartyReference, _that.getRequestingPartyReference())) return false;
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (requestingPartyReference != null ? requestingPartyReference.hashCode() : 0);
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestClearingEligibilityBuilder {" +
				"requestingPartyReference=" + this.requestingPartyReference + ", " +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"deClear=" + this.deClear + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
