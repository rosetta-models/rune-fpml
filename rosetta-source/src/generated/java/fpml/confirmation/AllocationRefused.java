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
import fpml.confirmation.AllocationRefused;
import fpml.confirmation.AllocationRefused.AllocationRefusedBuilder;
import fpml.confirmation.AllocationRefused.AllocationRefusedBuilderImpl;
import fpml.confirmation.AllocationRefused.AllocationRefusedImpl;
import fpml.confirmation.Allocations;
import fpml.confirmation.CorrelationAndOptionalSequenceModel;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.Reason;
import fpml.confirmation.ResponseMessage;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilder;
import fpml.confirmation.ResponseMessage.ResponseMessageBuilderImpl;
import fpml.confirmation.ResponseMessage.ResponseMessageImpl;
import fpml.confirmation.ResponseMessageHeader;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.AllocationRefusedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message indicating that a request to allocate a trade has been refused by the sender.
 * @version ${project.version}
 */
@RosettaDataType(value="AllocationRefused", builder=AllocationRefused.AllocationRefusedBuilderImpl.class, version="${project.version}")
public interface AllocationRefused extends ResponseMessage {

	AllocationRefusedMeta metaData = new AllocationRefusedMeta();

	/*********************** Getter Methods  ***********************/
	TradeIdentifier getBlockTradeIdentifier();
	Allocations getAllocations();
	PartiesAndAccountsModel getPartiesAndAccountsModel();
	List<? extends Reason> getReason();

	/*********************** Build Methods  ***********************/
	AllocationRefused build();
	
	AllocationRefused.AllocationRefusedBuilder toBuilder();
	
	static AllocationRefused.AllocationRefusedBuilder builder() {
		return new AllocationRefused.AllocationRefusedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AllocationRefused> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AllocationRefused> getType() {
		return AllocationRefused.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.class, getCorrelationAndOptionalSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("blockTradeIdentifier"), processor, TradeIdentifier.class, getBlockTradeIdentifier());
		processRosetta(path.newSubPath("allocations"), processor, Allocations.class, getAllocations());
		processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.class, getPartiesAndAccountsModel());
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationRefusedBuilder extends AllocationRefused, ResponseMessage.ResponseMessageBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeIdentifier();
		TradeIdentifier.TradeIdentifierBuilder getBlockTradeIdentifier();
		Allocations.AllocationsBuilder getOrCreateAllocations();
		Allocations.AllocationsBuilder getAllocations();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getOrCreatePartiesAndAccountsModel();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder getPartiesAndAccountsModel();
		Reason.ReasonBuilder getOrCreateReason(int _index);
		List<? extends Reason.ReasonBuilder> getReason();
		AllocationRefused.AllocationRefusedBuilder setExpectedBuild(Integer expectedBuild);
		AllocationRefused.AllocationRefusedBuilder setActualBuild(Integer actualBuild);
		AllocationRefused.AllocationRefusedBuilder setHeader(ResponseMessageHeader header);
		AllocationRefused.AllocationRefusedBuilder setValidationModel(ValidationModel validationModel);
		AllocationRefused.AllocationRefusedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel);
		AllocationRefused.AllocationRefusedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		AllocationRefused.AllocationRefusedBuilder setBlockTradeIdentifier(TradeIdentifier blockTradeIdentifier);
		AllocationRefused.AllocationRefusedBuilder setAllocations(Allocations allocations);
		AllocationRefused.AllocationRefusedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel);
		AllocationRefused.AllocationRefusedBuilder addReason(Reason reason0);
		AllocationRefused.AllocationRefusedBuilder addReason(Reason reason1, int _idx);
		AllocationRefused.AllocationRefusedBuilder addReason(List<? extends Reason> reason2);
		AllocationRefused.AllocationRefusedBuilder setReason(List<? extends Reason> reason3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndOptionalSequenceModel"), processor, CorrelationAndOptionalSequenceModel.CorrelationAndOptionalSequenceModelBuilder.class, getCorrelationAndOptionalSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("blockTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getBlockTradeIdentifier());
			processRosetta(path.newSubPath("allocations"), processor, Allocations.AllocationsBuilder.class, getAllocations());
			processRosetta(path.newSubPath("partiesAndAccountsModel"), processor, PartiesAndAccountsModel.PartiesAndAccountsModelBuilder.class, getPartiesAndAccountsModel());
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
		}
		

		AllocationRefused.AllocationRefusedBuilder prune();
	}

	/*********************** Immutable Implementation of AllocationRefused  ***********************/
	class AllocationRefusedImpl extends ResponseMessage.ResponseMessageImpl implements AllocationRefused {
		private final TradeIdentifier blockTradeIdentifier;
		private final Allocations allocations;
		private final PartiesAndAccountsModel partiesAndAccountsModel;
		private final List<? extends Reason> reason;
		
		protected AllocationRefusedImpl(AllocationRefused.AllocationRefusedBuilder builder) {
			super(builder);
			this.blockTradeIdentifier = ofNullable(builder.getBlockTradeIdentifier()).map(f->f.build()).orElse(null);
			this.allocations = ofNullable(builder.getAllocations()).map(f->f.build()).orElse(null);
			this.partiesAndAccountsModel = ofNullable(builder.getPartiesAndAccountsModel()).map(f->f.build()).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		public TradeIdentifier getBlockTradeIdentifier() {
			return blockTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("allocations")
		public Allocations getAllocations() {
			return allocations;
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
		public AllocationRefused build() {
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder toBuilder() {
			AllocationRefused.AllocationRefusedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AllocationRefused.AllocationRefusedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBlockTradeIdentifier()).ifPresent(builder::setBlockTradeIdentifier);
			ofNullable(getAllocations()).ifPresent(builder::setAllocations);
			ofNullable(getPartiesAndAccountsModel()).ifPresent(builder::setPartiesAndAccountsModel);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AllocationRefused _that = getType().cast(o);
		
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationRefused {" +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel + ", " +
				"reason=" + this.reason +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AllocationRefused  ***********************/
	class AllocationRefusedBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl  implements AllocationRefused.AllocationRefusedBuilder {
	
		protected TradeIdentifier.TradeIdentifierBuilder blockTradeIdentifier;
		protected Allocations.AllocationsBuilder allocations;
		protected PartiesAndAccountsModel.PartiesAndAccountsModelBuilder partiesAndAccountsModel;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
	
		public AllocationRefusedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getBlockTradeIdentifier() {
			return blockTradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateBlockTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (blockTradeIdentifier!=null) {
				result = blockTradeIdentifier;
			}
			else {
				result = blockTradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocations")
		public Allocations.AllocationsBuilder getAllocations() {
			return allocations;
		}
		
		@Override
		public Allocations.AllocationsBuilder getOrCreateAllocations() {
			Allocations.AllocationsBuilder result;
			if (allocations!=null) {
				result = allocations;
			}
			else {
				result = allocations = Allocations.builder();
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
		public AllocationRefused.AllocationRefusedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public AllocationRefused.AllocationRefusedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public AllocationRefused.AllocationRefusedBuilder setHeader(ResponseMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public AllocationRefused.AllocationRefusedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndOptionalSequenceModel")
		public AllocationRefused.AllocationRefusedBuilder setCorrelationAndOptionalSequenceModel(CorrelationAndOptionalSequenceModel correlationAndOptionalSequenceModel) {
			this.correlationAndOptionalSequenceModel = correlationAndOptionalSequenceModel==null?null:correlationAndOptionalSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public AllocationRefused.AllocationRefusedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("blockTradeIdentifier")
		public AllocationRefused.AllocationRefusedBuilder setBlockTradeIdentifier(TradeIdentifier blockTradeIdentifier) {
			this.blockTradeIdentifier = blockTradeIdentifier==null?null:blockTradeIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocations")
		public AllocationRefused.AllocationRefusedBuilder setAllocations(Allocations allocations) {
			this.allocations = allocations==null?null:allocations.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("partiesAndAccountsModel")
		public AllocationRefused.AllocationRefusedBuilder setPartiesAndAccountsModel(PartiesAndAccountsModel partiesAndAccountsModel) {
			this.partiesAndAccountsModel = partiesAndAccountsModel==null?null:partiesAndAccountsModel.toBuilder();
			return this;
		}
		@Override
		public AllocationRefused.AllocationRefusedBuilder addReason(Reason reason) {
			if (reason!=null) this.reason.add(reason.toBuilder());
			return this;
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder addReason(Reason reason, int _idx) {
			getIndex(this.reason, _idx, () -> reason.toBuilder());
			return this;
		}
		@Override 
		public AllocationRefused.AllocationRefusedBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("reason")
		public AllocationRefused.AllocationRefusedBuilder setReason(List<? extends Reason> reasons) {
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
		public AllocationRefused build() {
			return new AllocationRefused.AllocationRefusedImpl(this);
		}
		
		@Override
		public AllocationRefused.AllocationRefusedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationRefused.AllocationRefusedBuilder prune() {
			super.prune();
			if (blockTradeIdentifier!=null && !blockTradeIdentifier.prune().hasData()) blockTradeIdentifier = null;
			if (allocations!=null && !allocations.prune().hasData()) allocations = null;
			if (partiesAndAccountsModel!=null && !partiesAndAccountsModel.prune().hasData()) partiesAndAccountsModel = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBlockTradeIdentifier()!=null && getBlockTradeIdentifier().hasData()) return true;
			if (getAllocations()!=null && getAllocations().hasData()) return true;
			if (getPartiesAndAccountsModel()!=null && getPartiesAndAccountsModel().hasData()) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AllocationRefused.AllocationRefusedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AllocationRefused.AllocationRefusedBuilder o = (AllocationRefused.AllocationRefusedBuilder) other;
			
			merger.mergeRosetta(getBlockTradeIdentifier(), o.getBlockTradeIdentifier(), this::setBlockTradeIdentifier);
			merger.mergeRosetta(getAllocations(), o.getAllocations(), this::setAllocations);
			merger.mergeRosetta(getPartiesAndAccountsModel(), o.getPartiesAndAccountsModel(), this::setPartiesAndAccountsModel);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AllocationRefused _that = getType().cast(o);
		
			if (!Objects.equals(blockTradeIdentifier, _that.getBlockTradeIdentifier())) return false;
			if (!Objects.equals(allocations, _that.getAllocations())) return false;
			if (!Objects.equals(partiesAndAccountsModel, _that.getPartiesAndAccountsModel())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (blockTradeIdentifier != null ? blockTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (allocations != null ? allocations.hashCode() : 0);
			_result = 31 * _result + (partiesAndAccountsModel != null ? partiesAndAccountsModel.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationRefusedBuilder {" +
				"blockTradeIdentifier=" + this.blockTradeIdentifier + ", " +
				"allocations=" + this.allocations + ", " +
				"partiesAndAccountsModel=" + this.partiesAndAccountsModel + ", " +
				"reason=" + this.reason +
			'}' + " " + super.toString();
		}
	}
}
