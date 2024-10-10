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
import fpml.confirmation.PortfolioReferenceOrReportIdentificationModel;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestRetransmission;
import fpml.confirmation.RequestRetransmission.RequestRetransmissionBuilder;
import fpml.confirmation.RequestRetransmission.RequestRetransmissionBuilderImpl;
import fpml.confirmation.RequestRetransmission.RequestRetransmissionImpl;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestRetransmissionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A message to request that a message be retransmitted. The original message will typically be a component of a group of messages, such as a portfolio or a report in multiple parts.
 * @version ${project.version}
 */
@RosettaDataType(value="RequestRetransmission", builder=RequestRetransmission.RequestRetransmissionBuilderImpl.class, version="${project.version}")
public interface RequestRetransmission extends NonCorrectableRequestMessage {

	RequestRetransmissionMeta metaData = new RequestRetransmissionMeta();

	/*********************** Getter Methods  ***********************/
	PortfolioReferenceOrReportIdentificationModel getPortfolioReferenceOrReportIdentificationModel();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestRetransmission build();
	
	RequestRetransmission.RequestRetransmissionBuilder toBuilder();
	
	static RequestRetransmission.RequestRetransmissionBuilder builder() {
		return new RequestRetransmission.RequestRetransmissionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestRetransmission> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestRetransmission> getType() {
		return RequestRetransmission.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("portfolioReferenceOrReportIdentificationModel"), processor, PortfolioReferenceOrReportIdentificationModel.class, getPortfolioReferenceOrReportIdentificationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestRetransmissionBuilder extends RequestRetransmission, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder getOrCreatePortfolioReferenceOrReportIdentificationModel();
		PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder getPortfolioReferenceOrReportIdentificationModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestRetransmission.RequestRetransmissionBuilder setExpectedBuild(Integer expectedBuild);
		RequestRetransmission.RequestRetransmissionBuilder setActualBuild(Integer actualBuild);
		RequestRetransmission.RequestRetransmissionBuilder setHeader(RequestMessageHeader header);
		RequestRetransmission.RequestRetransmissionBuilder setValidationModel(ValidationModel validationModel);
		RequestRetransmission.RequestRetransmissionBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestRetransmission.RequestRetransmissionBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestRetransmission.RequestRetransmissionBuilder setPortfolioReferenceOrReportIdentificationModel(PortfolioReferenceOrReportIdentificationModel portfolioReferenceOrReportIdentificationModel);
		RequestRetransmission.RequestRetransmissionBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("portfolioReferenceOrReportIdentificationModel"), processor, PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder.class, getPortfolioReferenceOrReportIdentificationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestRetransmission.RequestRetransmissionBuilder prune();
	}

	/*********************** Immutable Implementation of RequestRetransmission  ***********************/
	class RequestRetransmissionImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements RequestRetransmission {
		private final PortfolioReferenceOrReportIdentificationModel portfolioReferenceOrReportIdentificationModel;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestRetransmissionImpl(RequestRetransmission.RequestRetransmissionBuilder builder) {
			super(builder);
			this.portfolioReferenceOrReportIdentificationModel = ofNullable(builder.getPortfolioReferenceOrReportIdentificationModel()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolioReferenceOrReportIdentificationModel")
		public PortfolioReferenceOrReportIdentificationModel getPortfolioReferenceOrReportIdentificationModel() {
			return portfolioReferenceOrReportIdentificationModel;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestRetransmission build() {
			return this;
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder toBuilder() {
			RequestRetransmission.RequestRetransmissionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestRetransmission.RequestRetransmissionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getPortfolioReferenceOrReportIdentificationModel()).ifPresent(builder::setPortfolioReferenceOrReportIdentificationModel);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestRetransmission _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReferenceOrReportIdentificationModel, _that.getPortfolioReferenceOrReportIdentificationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (portfolioReferenceOrReportIdentificationModel != null ? portfolioReferenceOrReportIdentificationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestRetransmission {" +
				"portfolioReferenceOrReportIdentificationModel=" + this.portfolioReferenceOrReportIdentificationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestRetransmission  ***********************/
	class RequestRetransmissionBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements RequestRetransmission.RequestRetransmissionBuilder {
	
		protected PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder portfolioReferenceOrReportIdentificationModel;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestRetransmissionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("portfolioReferenceOrReportIdentificationModel")
		public PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder getPortfolioReferenceOrReportIdentificationModel() {
			return portfolioReferenceOrReportIdentificationModel;
		}
		
		@Override
		public PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder getOrCreatePortfolioReferenceOrReportIdentificationModel() {
			PortfolioReferenceOrReportIdentificationModel.PortfolioReferenceOrReportIdentificationModelBuilder result;
			if (portfolioReferenceOrReportIdentificationModel!=null) {
				result = portfolioReferenceOrReportIdentificationModel;
			}
			else {
				result = portfolioReferenceOrReportIdentificationModel = PortfolioReferenceOrReportIdentificationModel.builder();
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
		public RequestRetransmission.RequestRetransmissionBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestRetransmission.RequestRetransmissionBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestRetransmission.RequestRetransmissionBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestRetransmission.RequestRetransmissionBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestRetransmission.RequestRetransmissionBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestRetransmission.RequestRetransmissionBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("portfolioReferenceOrReportIdentificationModel")
		public RequestRetransmission.RequestRetransmissionBuilder setPortfolioReferenceOrReportIdentificationModel(PortfolioReferenceOrReportIdentificationModel portfolioReferenceOrReportIdentificationModel) {
			this.portfolioReferenceOrReportIdentificationModel = portfolioReferenceOrReportIdentificationModel==null?null:portfolioReferenceOrReportIdentificationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestRetransmission.RequestRetransmissionBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestRetransmission build() {
			return new RequestRetransmission.RequestRetransmissionImpl(this);
		}
		
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder prune() {
			super.prune();
			if (portfolioReferenceOrReportIdentificationModel!=null && !portfolioReferenceOrReportIdentificationModel.prune().hasData()) portfolioReferenceOrReportIdentificationModel = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getPortfolioReferenceOrReportIdentificationModel()!=null && getPortfolioReferenceOrReportIdentificationModel().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestRetransmission.RequestRetransmissionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestRetransmission.RequestRetransmissionBuilder o = (RequestRetransmission.RequestRetransmissionBuilder) other;
			
			merger.mergeRosetta(getPortfolioReferenceOrReportIdentificationModel(), o.getPortfolioReferenceOrReportIdentificationModel(), this::setPortfolioReferenceOrReportIdentificationModel);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestRetransmission _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReferenceOrReportIdentificationModel, _that.getPortfolioReferenceOrReportIdentificationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (portfolioReferenceOrReportIdentificationModel != null ? portfolioReferenceOrReportIdentificationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestRetransmissionBuilder {" +
				"portfolioReferenceOrReportIdentificationModel=" + this.portfolioReferenceOrReportIdentificationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
