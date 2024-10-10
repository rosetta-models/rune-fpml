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
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.EventStatusItem;
import fpml.confirmation.EventStatusResponse;
import fpml.confirmation.EventStatusResponse.EventStatusResponseBuilder;
import fpml.confirmation.EventStatusResponse.EventStatusResponseBuilderImpl;
import fpml.confirmation.EventStatusResponse.EventStatusResponseImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.EventStatusResponseMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the content model for a message normally generated in response to a requestEventStatus request.
 * @version ${project.version}
 */
@RosettaDataType(value="EventStatusResponse", builder=EventStatusResponse.EventStatusResponseBuilderImpl.class, version="${project.version}")
public interface EventStatusResponse extends ResponseMessage {

	EventStatusResponseMeta metaData = new EventStatusResponseMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends EventStatusItem> getStatusItem();
	PartiesAndAccountsModel getPartiesAndAccountsModel();

	/*********************** Build Methods  ***********************/
	EventStatusResponse build();
	
	EventStatusResponse.EventStatusResponseBuilder toBuilder();
	
	static EventStatusResponse.EventStatusResponseBuilder builder() {
		return new EventStatusResponse.EventStatusResponseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EventStatusResponse> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EventStatusResponse> getType() {
		return EventStatusResponse.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("statusItem"), processor, EventStatusItem.class, getStatusItem());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EventStatusResponseBuilder extends EventStatusResponse, ResponseMessage.ResponseMessageBuilder {
		EventStatusItem.EventStatusItemBuilder getOrCreateStatusItem(int _index);
		List<? extends EventStatusItem.EventStatusItemBuilder> getStatusItem();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		EventStatusResponse.EventStatusResponseBuilder setExpectedBuild(Integer expectedBuild);
		EventStatusResponse.EventStatusResponseBuilder setActualBuild(Integer actualBuild);
		EventStatusResponse.EventStatusResponseBuilder setHeader(ResponseMessageHeader header);
		EventStatusResponse.EventStatusResponseBuilder setValidationModel(ValidationModel validationModel);
		EventStatusResponse.EventStatusResponseBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		EventStatusResponse.EventStatusResponseBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		EventStatusResponse.EventStatusResponseBuilder addStatusItem(EventStatusItem statusItem0);
		EventStatusResponse.EventStatusResponseBuilder addStatusItem(EventStatusItem statusItem1, int _idx);
		EventStatusResponse.EventStatusResponseBuilder addStatusItem(List<? extends EventStatusItem> statusItem2);
		EventStatusResponse.EventStatusResponseBuilder setStatusItem(List<? extends EventStatusItem> statusItem3);
		EventStatusResponse.EventStatusResponseBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("statusItem"), processor, EventStatusItem.EventStatusItemBuilder.class, getStatusItem());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
		}
		

		EventStatusResponse.EventStatusResponseBuilder prune();
	}

	/*********************** Immutable Implementation of EventStatusResponse  ***********************/
	class EventStatusResponseImpl extends ResponseMessage.ResponseMessageImpl implements EventStatusResponse {
		private final List<? extends EventStatusItem> statusItem;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		
		protected EventStatusResponseImpl(EventStatusResponse.EventStatusResponseBuilder builder) {
			super(builder);
			this.statusItem = ofNullable(builder.getStatusItem()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("statusItem")
		public List<? extends EventStatusItem> getStatusItem() {
			return statusItem;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		public EventStatusResponse build() {
			return this;
		}
		
		@Override
		public EventStatusResponse.EventStatusResponseBuilder toBuilder() {
			EventStatusResponse.EventStatusResponseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EventStatusResponse.EventStatusResponseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStatusItem()).ifPresent(builder::setStatusItem);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EventStatusResponse _that = getType().cast(o);
		
			if (!ListEquals.listEquals(statusItem, _that.getStatusItem())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (statusItem != null ? statusItem.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventStatusResponse {" +
				"statusItem=" + this.statusItem + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EventStatusResponse  ***********************/
	class EventStatusResponseBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements EventStatusResponse.EventStatusResponseBuilder {
	
		protected List<EventStatusItem.EventStatusItemBuilder> statusItem = new ArrayList<>();
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
	
		public EventStatusResponseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("statusItem")
		public List<? extends EventStatusItem.EventStatusItemBuilder> getStatusItem() {
			return statusItem;
		}
		
		public EventStatusItem.EventStatusItemBuilder getOrCreateStatusItem(int _index) {
		
			if (statusItem==null) {
				this.statusItem = new ArrayList<>();
			}
			EventStatusItem.EventStatusItemBuilder result;
			return getIndex(statusItem, _index, () -> {
						EventStatusItem.EventStatusItemBuilder newStatusItem = EventStatusItem.builder();
						return newStatusItem;
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
		public EventStatusResponse.EventStatusResponseBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public EventStatusResponse.EventStatusResponseBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public EventStatusResponse.EventStatusResponseBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public EventStatusResponse.EventStatusResponseBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public EventStatusResponse.EventStatusResponseBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public EventStatusResponse.EventStatusResponseBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		public EventStatusResponse.EventStatusResponseBuilder addStatusItem(EventStatusItem statusItem) {
			if (statusItem!=null) this.statusItem.add(statusItem.toBuilder());
			return this;
		}
		
		@Override
		public EventStatusResponse.EventStatusResponseBuilder addStatusItem(EventStatusItem statusItem, int _idx) {
			getIndex(this.statusItem, _idx, () -> statusItem.toBuilder());
			return this;
		}
		@Override 
		public EventStatusResponse.EventStatusResponseBuilder addStatusItem(List<? extends EventStatusItem> statusItems) {
			if (statusItems != null) {
				for (EventStatusItem toAdd : statusItems) {
					this.statusItem.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("statusItem")
		public EventStatusResponse.EventStatusResponseBuilder setStatusItem(List<? extends EventStatusItem> statusItems) {
			if (statusItems == null)  {
				this.statusItem = new ArrayList<>();
			}
			else {
				this.statusItem = statusItems.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public EventStatusResponse.EventStatusResponseBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		
		@Override
		public EventStatusResponse build() {
			return new EventStatusResponse.EventStatusResponseImpl(this);
		}
		
		@Override
		public EventStatusResponse.EventStatusResponseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventStatusResponse.EventStatusResponseBuilder prune() {
			super.prune();
			statusItem = statusItem.stream().filter(b->b!=null).<EventStatusItem.EventStatusItemBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStatusItem()!=null && getStatusItem().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EventStatusResponse.EventStatusResponseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			EventStatusResponse.EventStatusResponseBuilder o = (EventStatusResponse.EventStatusResponseBuilder) other;
			
			merger.mergeRosetta(getStatusItem(), o.getStatusItem(), this::getOrCreateStatusItem);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EventStatusResponse _that = getType().cast(o);
		
			if (!ListEquals.listEquals(statusItem, _that.getStatusItem())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (statusItem != null ? statusItem.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EventStatusResponseBuilder {" +
				"statusItem=" + this.statusItem + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel +
			'}' + " " + super.toString();
		}
	}
}
