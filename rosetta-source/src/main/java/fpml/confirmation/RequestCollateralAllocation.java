package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartyReference;
import fpml.confirmation.ProposedCollateralAllocation;
import fpml.confirmation.RequestCollateralAllocation;
import fpml.confirmation.RequestCollateralAllocation.RequestCollateralAllocationBuilder;
import fpml.confirmation.RequestCollateralAllocation.RequestCollateralAllocationBuilderImpl;
import fpml.confirmation.RequestCollateralAllocation.RequestCollateralAllocationImpl;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.RequestedCollateralAllocationAction;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.RequestCollateralAllocationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RequestCollateralAllocation", builder=RequestCollateralAllocation.RequestCollateralAllocationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RequestCollateralAllocation extends CorrectableRequestMessage {

	RequestCollateralAllocationMeta metaData = new RequestCollateralAllocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the service to which the message applies
	 */
	String getServiceName();
	/**
	 * The type of change requested for the collateral allocation.
	 */
	RequestedCollateralAllocationAction getRequestedAction();
	/**
	 * The party paying the margin / issuing the allocation request.
	 */
	PartyReference getCollateralGiverPartyReference();
	/**
	 * Allocation details
	 */
	List<? extends ProposedCollateralAllocation> getCollateralAllocation();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	RequestCollateralAllocation build();
	
	RequestCollateralAllocation.RequestCollateralAllocationBuilder toBuilder();
	
	static RequestCollateralAllocation.RequestCollateralAllocationBuilder builder() {
		return new RequestCollateralAllocation.RequestCollateralAllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestCollateralAllocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RequestCollateralAllocation> getType() {
		return RequestCollateralAllocation.class;
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
		processor.processBasic(path.newSubPath("serviceName"), String.class, getServiceName(), this);
		processRosetta(path.newSubPath("requestedAction"), processor, RequestedCollateralAllocationAction.class, getRequestedAction());
		processRosetta(path.newSubPath("collateralGiverPartyReference"), processor, PartyReference.class, getCollateralGiverPartyReference());
		processRosetta(path.newSubPath("collateralAllocation"), processor, ProposedCollateralAllocation.class, getCollateralAllocation());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestCollateralAllocationBuilder extends RequestCollateralAllocation, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder getOrCreateRequestedAction();
		RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder getRequestedAction();
		PartyReference.PartyReferenceBuilder getOrCreateCollateralGiverPartyReference();
		PartyReference.PartyReferenceBuilder getCollateralGiverPartyReference();
		ProposedCollateralAllocation.ProposedCollateralAllocationBuilder getOrCreateCollateralAllocation(int _index);
		List<? extends ProposedCollateralAllocation.ProposedCollateralAllocationBuilder> getCollateralAllocation();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setExpectedBuild(Integer expectedBuild);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setActualBuild(Integer actualBuild);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setHeader(RequestMessageHeader header);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setValidationModel(ValidationModel validationModel);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setIsCorrection(Boolean isCorrection);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setServiceName(String serviceName);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setRequestedAction(RequestedCollateralAllocationAction requestedAction);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setCollateralGiverPartyReference(PartyReference collateralGiverPartyReference);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(ProposedCollateralAllocation collateralAllocation0);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(ProposedCollateralAllocation collateralAllocation1, int _idx);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(List<? extends ProposedCollateralAllocation> collateralAllocation2);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setCollateralAllocation(List<? extends ProposedCollateralAllocation> collateralAllocation3);
		RequestCollateralAllocation.RequestCollateralAllocationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("serviceName"), String.class, getServiceName(), this);
			processRosetta(path.newSubPath("requestedAction"), processor, RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder.class, getRequestedAction());
			processRosetta(path.newSubPath("collateralGiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getCollateralGiverPartyReference());
			processRosetta(path.newSubPath("collateralAllocation"), processor, ProposedCollateralAllocation.ProposedCollateralAllocationBuilder.class, getCollateralAllocation());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		RequestCollateralAllocation.RequestCollateralAllocationBuilder prune();
	}

	/*********************** Immutable Implementation of RequestCollateralAllocation  ***********************/
	class RequestCollateralAllocationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestCollateralAllocation {
		private final String serviceName;
		private final RequestedCollateralAllocationAction requestedAction;
		private final PartyReference collateralGiverPartyReference;
		private final List<? extends ProposedCollateralAllocation> collateralAllocation;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected RequestCollateralAllocationImpl(RequestCollateralAllocation.RequestCollateralAllocationBuilder builder) {
			super(builder);
			this.serviceName = builder.getServiceName();
			this.requestedAction = ofNullable(builder.getRequestedAction()).map(f->f.build()).orElse(null);
			this.collateralGiverPartyReference = ofNullable(builder.getCollateralGiverPartyReference()).map(f->f.build()).orElse(null);
			this.collateralAllocation = ofNullable(builder.getCollateralAllocation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("serviceName")
		public String getServiceName() {
			return serviceName;
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		public RequestedCollateralAllocationAction getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		@RosettaAttribute("collateralGiverPartyReference")
		public PartyReference getCollateralGiverPartyReference() {
			return collateralGiverPartyReference;
		}
		
		@Override
		@RosettaAttribute("collateralAllocation")
		public List<? extends ProposedCollateralAllocation> getCollateralAllocation() {
			return collateralAllocation;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public RequestCollateralAllocation build() {
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder toBuilder() {
			RequestCollateralAllocation.RequestCollateralAllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestCollateralAllocation.RequestCollateralAllocationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getServiceName()).ifPresent(builder::setServiceName);
			ofNullable(getRequestedAction()).ifPresent(builder::setRequestedAction);
			ofNullable(getCollateralGiverPartyReference()).ifPresent(builder::setCollateralGiverPartyReference);
			ofNullable(getCollateralAllocation()).ifPresent(builder::setCollateralAllocation);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestCollateralAllocation _that = getType().cast(o);
		
			if (!Objects.equals(serviceName, _that.getServiceName())) return false;
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!Objects.equals(collateralGiverPartyReference, _that.getCollateralGiverPartyReference())) return false;
			if (!ListEquals.listEquals(collateralAllocation, _that.getCollateralAllocation())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (serviceName != null ? serviceName.hashCode() : 0);
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (collateralGiverPartyReference != null ? collateralGiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (collateralAllocation != null ? collateralAllocation.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestCollateralAllocation {" +
				"serviceName=" + this.serviceName + ", " +
				"requestedAction=" + this.requestedAction + ", " +
				"collateralGiverPartyReference=" + this.collateralGiverPartyReference + ", " +
				"collateralAllocation=" + this.collateralAllocation + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestCollateralAllocation  ***********************/
	class RequestCollateralAllocationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements RequestCollateralAllocation.RequestCollateralAllocationBuilder {
	
		protected String serviceName;
		protected RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder requestedAction;
		protected PartyReference.PartyReferenceBuilder collateralGiverPartyReference;
		protected List<ProposedCollateralAllocation.ProposedCollateralAllocationBuilder> collateralAllocation = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public RequestCollateralAllocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("serviceName")
		public String getServiceName() {
			return serviceName;
		}
		
		@Override
		@RosettaAttribute("requestedAction")
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder getRequestedAction() {
			return requestedAction;
		}
		
		@Override
		public RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder getOrCreateRequestedAction() {
			RequestedCollateralAllocationAction.RequestedCollateralAllocationActionBuilder result;
			if (requestedAction!=null) {
				result = requestedAction;
			}
			else {
				result = requestedAction = RequestedCollateralAllocationAction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralGiverPartyReference")
		public PartyReference.PartyReferenceBuilder getCollateralGiverPartyReference() {
			return collateralGiverPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateCollateralGiverPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (collateralGiverPartyReference!=null) {
				result = collateralGiverPartyReference;
			}
			else {
				result = collateralGiverPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralAllocation")
		public List<? extends ProposedCollateralAllocation.ProposedCollateralAllocationBuilder> getCollateralAllocation() {
			return collateralAllocation;
		}
		
		@Override
		public ProposedCollateralAllocation.ProposedCollateralAllocationBuilder getOrCreateCollateralAllocation(int _index) {
		
			if (collateralAllocation==null) {
				this.collateralAllocation = new ArrayList<>();
			}
			ProposedCollateralAllocation.ProposedCollateralAllocationBuilder result;
			return getIndex(collateralAllocation, _index, () -> {
						ProposedCollateralAllocation.ProposedCollateralAllocationBuilder newCollateralAllocation = ProposedCollateralAllocation.builder();
						return newCollateralAllocation;
					});
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
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("serviceName")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setServiceName(String serviceName) {
			this.serviceName = serviceName==null?null:serviceName;
			return this;
		}
		@Override
		@RosettaAttribute("requestedAction")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setRequestedAction(RequestedCollateralAllocationAction requestedAction) {
			this.requestedAction = requestedAction==null?null:requestedAction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("collateralGiverPartyReference")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setCollateralGiverPartyReference(PartyReference collateralGiverPartyReference) {
			this.collateralGiverPartyReference = collateralGiverPartyReference==null?null:collateralGiverPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("collateralAllocation")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(ProposedCollateralAllocation collateralAllocation) {
			if (collateralAllocation!=null) this.collateralAllocation.add(collateralAllocation.toBuilder());
			return this;
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(ProposedCollateralAllocation collateralAllocation, int _idx) {
			getIndex(this.collateralAllocation, _idx, () -> collateralAllocation.toBuilder());
			return this;
		}
		@Override 
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder addCollateralAllocation(List<? extends ProposedCollateralAllocation> collateralAllocations) {
			if (collateralAllocations != null) {
				for (ProposedCollateralAllocation toAdd : collateralAllocations) {
					this.collateralAllocation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setCollateralAllocation(List<? extends ProposedCollateralAllocation> collateralAllocations) {
			if (collateralAllocations == null)  {
				this.collateralAllocation = new ArrayList<>();
			}
			else {
				this.collateralAllocation = collateralAllocations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public RequestCollateralAllocation build() {
			return new RequestCollateralAllocation.RequestCollateralAllocationImpl(this);
		}
		
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder prune() {
			super.prune();
			if (requestedAction!=null && !requestedAction.prune().hasData()) requestedAction = null;
			if (collateralGiverPartyReference!=null && !collateralGiverPartyReference.prune().hasData()) collateralGiverPartyReference = null;
			collateralAllocation = collateralAllocation.stream().filter(b->b!=null).<ProposedCollateralAllocation.ProposedCollateralAllocationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getServiceName()!=null) return true;
			if (getRequestedAction()!=null && getRequestedAction().hasData()) return true;
			if (getCollateralGiverPartyReference()!=null && getCollateralGiverPartyReference().hasData()) return true;
			if (getCollateralAllocation()!=null && getCollateralAllocation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestCollateralAllocation.RequestCollateralAllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			RequestCollateralAllocation.RequestCollateralAllocationBuilder o = (RequestCollateralAllocation.RequestCollateralAllocationBuilder) other;
			
			merger.mergeRosetta(getRequestedAction(), o.getRequestedAction(), this::setRequestedAction);
			merger.mergeRosetta(getCollateralGiverPartyReference(), o.getCollateralGiverPartyReference(), this::setCollateralGiverPartyReference);
			merger.mergeRosetta(getCollateralAllocation(), o.getCollateralAllocation(), this::getOrCreateCollateralAllocation);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			merger.mergeBasic(getServiceName(), o.getServiceName(), this::setServiceName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestCollateralAllocation _that = getType().cast(o);
		
			if (!Objects.equals(serviceName, _that.getServiceName())) return false;
			if (!Objects.equals(requestedAction, _that.getRequestedAction())) return false;
			if (!Objects.equals(collateralGiverPartyReference, _that.getCollateralGiverPartyReference())) return false;
			if (!ListEquals.listEquals(collateralAllocation, _that.getCollateralAllocation())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (serviceName != null ? serviceName.hashCode() : 0);
			_result = 31 * _result + (requestedAction != null ? requestedAction.hashCode() : 0);
			_result = 31 * _result + (collateralGiverPartyReference != null ? collateralGiverPartyReference.hashCode() : 0);
			_result = 31 * _result + (collateralAllocation != null ? collateralAllocation.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestCollateralAllocationBuilder {" +
				"serviceName=" + this.serviceName + ", " +
				"requestedAction=" + this.requestedAction + ", " +
				"collateralGiverPartyReference=" + this.collateralGiverPartyReference + ", " +
				"collateralAllocation=" + this.collateralAllocation + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
