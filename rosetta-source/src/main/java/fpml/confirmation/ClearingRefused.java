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
import fpml.confirmation.ClearingRefused;
import fpml.confirmation.ClearingRefused.ClearingRefusedBuilder;
import fpml.confirmation.ClearingRefused.ClearingRefusedBuilderImpl;
import fpml.confirmation.ClearingRefused.ClearingRefusedImpl;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.EventValuationModel;
import fpml.confirmation.NotificationMessage;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilder;
import fpml.confirmation.NotificationMessage.NotificationMessageBuilderImpl;
import fpml.confirmation.NotificationMessage.NotificationMessageImpl;
import fpml.confirmation.NotificationMessageHeader;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.Reason;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.ClearingRefusedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message indicating that a clearing request has not been acted on due to a business decision and therefore no trade has been cleared.
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingRefused", builder=ClearingRefused.ClearingRefusedBuilderImpl.class, version="${project.version}")
public interface ClearingRefused extends NotificationMessage {

	ClearingRefusedMeta metaData = new ClearingRefusedMeta();

	/*********************** Getter Methods  ***********************/
	TradingEventsModel getTradingEventsModel();
	EventValuationModel getEventValuationModel();
	PartiesAndAccountsModel getPartiesAndAccountsModel();
	List<? extends Reason> getReason();

	/*********************** Build Methods  ***********************/
	ClearingRefused build();
	
	ClearingRefused.ClearingRefusedBuilder toBuilder();
	
	static ClearingRefused.ClearingRefusedBuilder builder() {
		return new ClearingRefused.ClearingRefusedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingRefused> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ClearingRefused> getType() {
		return ClearingRefused.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.class, getTradingEventsModel());
		processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.class, getEventValuationModel());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingRefusedBuilder extends ClearingRefused, NotificationMessage.NotificationMessageBuilder {
		TradingEventsModel.TradingEventsModelBuilder getOrCreateTradingEventsModel();
		TradingEventsModel.TradingEventsModelBuilder getTradingEventsModel();
		EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel();
		EventValuationModel.EventValuationModelBuilder getEventValuationModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		Reason.ReasonBuilder getOrCreateReason(int _index);
		List<? extends Reason.ReasonBuilder> getReason();
		ClearingRefused.ClearingRefusedBuilder setExpectedBuild(Integer expectedBuild);
		ClearingRefused.ClearingRefusedBuilder setActualBuild(Integer actualBuild);
		ClearingRefused.ClearingRefusedBuilder setHeader(NotificationMessageHeader header);
		ClearingRefused.ClearingRefusedBuilder setValidationModel(ValidationModel validationModel);
		ClearingRefused.ClearingRefusedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		ClearingRefused.ClearingRefusedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		ClearingRefused.ClearingRefusedBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel);
		ClearingRefused.ClearingRefusedBuilder setEventValuationModel(EventValuationModel eventValuationModel);
		ClearingRefused.ClearingRefusedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);
		ClearingRefused.ClearingRefusedBuilder addReason(Reason reason0);
		ClearingRefused.ClearingRefusedBuilder addReason(Reason reason1, int _idx);
		ClearingRefused.ClearingRefusedBuilder addReason(List<? extends Reason> reason2);
		ClearingRefused.ClearingRefusedBuilder setReason(List<? extends Reason> reason3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("tradingEventsModel"), processor, TradingEventsModel.TradingEventsModelBuilder.class, getTradingEventsModel());
			processRosetta(path.newSubPath("eventValuationModel"), processor, EventValuationModel.EventValuationModelBuilder.class, getEventValuationModel());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
		}
		

		ClearingRefused.ClearingRefusedBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingRefused  ***********************/
	class ClearingRefusedImpl extends NotificationMessage.NotificationMessageImpl implements ClearingRefused {
		private final TradingEventsModel tradingEventsModel;
		private final EventValuationModel eventValuationModel;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		private final List<? extends Reason> reason;
		
		protected ClearingRefusedImpl(ClearingRefused.ClearingRefusedBuilder builder) {
			super(builder);
			this.tradingEventsModel = ofNullable(builder.getTradingEventsModel()).map(f->f.build()).orElse(null);
			this.eventValuationModel = ofNullable(builder.getEventValuationModel()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradingEventsModel")
		public TradingEventsModel getTradingEventsModel() {
			return tradingEventsModel;
		}
		
		@Override
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public PartiesAndAccountsModel getPartiesAndAccountsModel() {
			return partiesAndAccountsModel;
		}
		
		@Override
		@RosettaAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		public ClearingRefused build() {
			return this;
		}
		
		@Override
		public ClearingRefused.ClearingRefusedBuilder toBuilder() {
			ClearingRefused.ClearingRefusedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingRefused.ClearingRefusedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradingEventsModel()).ifPresent(builder::setTradingEventsModel);
			ofNullable(getEventValuationModel()).ifPresent(builder::setEventValuationModel);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingRefused _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingRefused {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel + ", " +
				"reason=" + this.reason +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingRefused  ***********************/
	class ClearingRefusedBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl  implements ClearingRefused.ClearingRefusedBuilder {
	
		protected TradingEventsModel.TradingEventsModelBuilder tradingEventsModel;
		protected EventValuationModel.EventValuationModelBuilder eventValuationModel;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
	
		public ClearingRefusedBuilderImpl() {
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
		@RosettaAttribute("eventValuationModel")
		public EventValuationModel.EventValuationModelBuilder getEventValuationModel() {
			return eventValuationModel;
		}
		
		@Override
		public EventValuationModel.EventValuationModelBuilder getOrCreateEventValuationModel() {
			EventValuationModel.EventValuationModelBuilder result;
			if (eventValuationModel!=null) {
				result = eventValuationModel;
			}
			else {
				result = eventValuationModel = EventValuationModel.builder();
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
		@RosettaAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		public Reason.ReasonBuilder getOrCreateReason(int _index) {
		
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			Reason.ReasonBuilder result;
			return getIndex(reason, _index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public ClearingRefused.ClearingRefusedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public ClearingRefused.ClearingRefusedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public ClearingRefused.ClearingRefusedBuilder setHeader(NotificationMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public ClearingRefused.ClearingRefusedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public ClearingRefused.ClearingRefusedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public ClearingRefused.ClearingRefusedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tradingEventsModel")
		public ClearingRefused.ClearingRefusedBuilder setTradingEventsModel(TradingEventsModel tradingEventsModel) {
			this.tradingEventsModel = tradingEventsModel==null?null:tradingEventsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("eventValuationModel")
		public ClearingRefused.ClearingRefusedBuilder setEventValuationModel(EventValuationModel eventValuationModel) {
			this.eventValuationModel = eventValuationModel==null?null:eventValuationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public ClearingRefused.ClearingRefusedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		@Override
		public ClearingRefused.ClearingRefusedBuilder addReason(Reason reason) {
			if (reason!=null) this.reason.add(reason.toBuilder());
			return this;
		}
		
		@Override
		public ClearingRefused.ClearingRefusedBuilder addReason(Reason reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason.toBuilder());
			return this;
		}
		@Override 
		public ClearingRefused.ClearingRefusedBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reason")
		public ClearingRefused.ClearingRefusedBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null)  {
				this.reason = new ArrayList<>();
			}
			else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ClearingRefused build() {
			return new ClearingRefused.ClearingRefusedImpl(this);
		}
		
		@Override
		public ClearingRefused.ClearingRefusedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingRefused.ClearingRefusedBuilder prune() {
			super.prune();
			if (tradingEventsModel!=null && !tradingEventsModel.prune().hasData()) tradingEventsModel = null;
			if (eventValuationModel!=null && !eventValuationModel.prune().hasData()) eventValuationModel = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradingEventsModel()!=null && getTradingEventsModel().hasData()) return true;
			if (getEventValuationModel()!=null && getEventValuationModel().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingRefused.ClearingRefusedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ClearingRefused.ClearingRefusedBuilder o = (ClearingRefused.ClearingRefusedBuilder) other;
			
			merger.mergeRosetta(getTradingEventsModel(), o.getTradingEventsModel(), this::setTradingEventsModel);
			merger.mergeRosetta(getEventValuationModel(), o.getEventValuationModel(), this::setEventValuationModel);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingRefused _that = getType().cast(o);
		
			if (!Objects.equals(tradingEventsModel, _that.getTradingEventsModel())) return false;
			if (!Objects.equals(eventValuationModel, _that.getEventValuationModel())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradingEventsModel != null ? tradingEventsModel.hashCode() : 0);
			_result = 31 * _result + (eventValuationModel != null ? eventValuationModel.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingRefusedBuilder {" +
				"tradingEventsModel=" + this.tradingEventsModel + ", " +
				"eventValuationModel=" + this.eventValuationModel + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel + ", " +
				"reason=" + this.reason +
			'}' + " " + super.toString();
		}
	}
}
