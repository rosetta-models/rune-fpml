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
import fpml.confirmation.Allocation;
import fpml.confirmation.Allocation.AllocationBuilder;
import fpml.confirmation.Allocation.AllocationBuilderImpl;
import fpml.confirmation.Allocation.AllocationImpl;
import fpml.confirmation.AllocationContentModel;
import fpml.confirmation.Money;
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.TradeIdentifier;
import fpml.confirmation.meta.AllocationMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Allocation", builder=Allocation.AllocationBuilderImpl.class, version="${project.version}")
public interface Allocation extends RosettaModelObject {

	AllocationMeta metaData = new AllocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique ID for the allocation. Multiple allocation trade IDs are provided to allow for the use of USI/UTI representations along with party-specific trade identifiers.
	 */
	List<? extends TradeIdentifier> getAllocationTradeId();
	PartyAndAccountReferencesModel getPartyAndAccountReferencesModel();
	/**
	 * The fractional allocation (0.45 = 45%) of the notional and &quot;block&quot; fees to this particular client subaccount.
	 */
	BigDecimal getAllocatedFraction();
	/**
	 * The notional allocation (amount and currency) to this particular client account.
	 */
	List<? extends Money> getAllocatedNotional();
	AllocationContentModel getAllocationContentModel();

	/*********************** Build Methods  ***********************/
	Allocation build();
	
	Allocation.AllocationBuilder toBuilder();
	
	static Allocation.AllocationBuilder builder() {
		return new Allocation.AllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Allocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Allocation> getType() {
		return Allocation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocationTradeId"), processor, TradeIdentifier.class, getAllocationTradeId());
		processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.class, getPartyAndAccountReferencesModel());
		processor.processBasic(path.newSubPath("allocatedFraction"), BigDecimal.class, getAllocatedFraction(), this);
		processRosetta(path.newSubPath("allocatedNotional"), processor, Money.class, getAllocatedNotional());
		processRosetta(path.newSubPath("allocationContentModel"), processor, AllocationContentModel.class, getAllocationContentModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationBuilder extends Allocation, RosettaModelObjectBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateAllocationTradeId(int _index);
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getAllocationTradeId();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel();
		Money.MoneyBuilder getOrCreateAllocatedNotional(int _index);
		List<? extends Money.MoneyBuilder> getAllocatedNotional();
		AllocationContentModel.AllocationContentModelBuilder getOrCreateAllocationContentModel();
		AllocationContentModel.AllocationContentModelBuilder getAllocationContentModel();
		Allocation.AllocationBuilder addAllocationTradeId(TradeIdentifier allocationTradeId0);
		Allocation.AllocationBuilder addAllocationTradeId(TradeIdentifier allocationTradeId1, int _idx);
		Allocation.AllocationBuilder addAllocationTradeId(List<? extends TradeIdentifier> allocationTradeId2);
		Allocation.AllocationBuilder setAllocationTradeId(List<? extends TradeIdentifier> allocationTradeId3);
		Allocation.AllocationBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel);
		Allocation.AllocationBuilder setAllocatedFraction(BigDecimal allocatedFraction);
		Allocation.AllocationBuilder addAllocatedNotional(Money allocatedNotional0);
		Allocation.AllocationBuilder addAllocatedNotional(Money allocatedNotional1, int _idx);
		Allocation.AllocationBuilder addAllocatedNotional(List<? extends Money> allocatedNotional2);
		Allocation.AllocationBuilder setAllocatedNotional(List<? extends Money> allocatedNotional3);
		Allocation.AllocationBuilder setAllocationContentModel(AllocationContentModel allocationContentModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocationTradeId"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getAllocationTradeId());
			processRosetta(path.newSubPath("partyAndAccountReferencesModel"), processor, PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder.class, getPartyAndAccountReferencesModel());
			processor.processBasic(path.newSubPath("allocatedFraction"), BigDecimal.class, getAllocatedFraction(), this);
			processRosetta(path.newSubPath("allocatedNotional"), processor, Money.MoneyBuilder.class, getAllocatedNotional());
			processRosetta(path.newSubPath("allocationContentModel"), processor, AllocationContentModel.AllocationContentModelBuilder.class, getAllocationContentModel());
		}
		

		Allocation.AllocationBuilder prune();
	}

	/*********************** Immutable Implementation of Allocation  ***********************/
	class AllocationImpl implements Allocation {
		private final List<? extends TradeIdentifier> allocationTradeId;
		private final PartyAndAccountReferencesModel partyAndAccountReferencesModel;
		private final BigDecimal allocatedFraction;
		private final List<? extends Money> allocatedNotional;
		private final AllocationContentModel allocationContentModel;
		
		protected AllocationImpl(Allocation.AllocationBuilder builder) {
			this.allocationTradeId = ofNullable(builder.getAllocationTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyAndAccountReferencesModel = ofNullable(builder.getPartyAndAccountReferencesModel()).map(f->f.build()).orElse(null);
			this.allocatedFraction = builder.getAllocatedFraction();
			this.allocatedNotional = ofNullable(builder.getAllocatedNotional()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.allocationContentModel = ofNullable(builder.getAllocationContentModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocationTradeId")
		public List<? extends TradeIdentifier> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		@RosettaAttribute("allocatedFraction")
		public BigDecimal getAllocatedFraction() {
			return allocatedFraction;
		}
		
		@Override
		@RosettaAttribute("allocatedNotional")
		public List<? extends Money> getAllocatedNotional() {
			return allocatedNotional;
		}
		
		@Override
		@RosettaAttribute("allocationContentModel")
		public AllocationContentModel getAllocationContentModel() {
			return allocationContentModel;
		}
		
		@Override
		public Allocation build() {
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder toBuilder() {
			Allocation.AllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Allocation.AllocationBuilder builder) {
			ofNullable(getAllocationTradeId()).ifPresent(builder::setAllocationTradeId);
			ofNullable(getPartyAndAccountReferencesModel()).ifPresent(builder::setPartyAndAccountReferencesModel);
			ofNullable(getAllocatedFraction()).ifPresent(builder::setAllocatedFraction);
			ofNullable(getAllocatedNotional()).ifPresent(builder::setAllocatedNotional);
			ofNullable(getAllocationContentModel()).ifPresent(builder::setAllocationContentModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Allocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(allocatedFraction, _that.getAllocatedFraction())) return false;
			if (!ListEquals.listEquals(allocatedNotional, _that.getAllocatedNotional())) return false;
			if (!Objects.equals(allocationContentModel, _that.getAllocationContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (allocatedFraction != null ? allocatedFraction.hashCode() : 0);
			_result = 31 * _result + (allocatedNotional != null ? allocatedNotional.hashCode() : 0);
			_result = 31 * _result + (allocationContentModel != null ? allocationContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Allocation {" +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"allocatedFraction=" + this.allocatedFraction + ", " +
				"allocatedNotional=" + this.allocatedNotional + ", " +
				"allocationContentModel=" + this.allocationContentModel +
			'}';
		}
	}

	/*********************** Builder Implementation of Allocation  ***********************/
	class AllocationBuilderImpl implements Allocation.AllocationBuilder {
	
		protected List<TradeIdentifier.TradeIdentifierBuilder> allocationTradeId = new ArrayList<>();
		protected PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder partyAndAccountReferencesModel;
		protected BigDecimal allocatedFraction;
		protected List<Money.MoneyBuilder> allocatedNotional = new ArrayList<>();
		protected AllocationContentModel.AllocationContentModelBuilder allocationContentModel;
	
		public AllocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocationTradeId")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getAllocationTradeId() {
			return allocationTradeId;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateAllocationTradeId(int _index) {
		
			if (allocationTradeId==null) {
				this.allocationTradeId = new ArrayList<>();
			}
			TradeIdentifier.TradeIdentifierBuilder result;
			return getIndex(allocationTradeId, _index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newAllocationTradeId = TradeIdentifier.builder();
						return newAllocationTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getPartyAndAccountReferencesModel() {
			return partyAndAccountReferencesModel;
		}
		
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder getOrCreatePartyAndAccountReferencesModel() {
			PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder result;
			if (partyAndAccountReferencesModel!=null) {
				result = partyAndAccountReferencesModel;
			}
			else {
				result = partyAndAccountReferencesModel = PartyAndAccountReferencesModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocatedFraction")
		public BigDecimal getAllocatedFraction() {
			return allocatedFraction;
		}
		
		@Override
		@RosettaAttribute("allocatedNotional")
		public List<? extends Money.MoneyBuilder> getAllocatedNotional() {
			return allocatedNotional;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAllocatedNotional(int _index) {
		
			if (allocatedNotional==null) {
				this.allocatedNotional = new ArrayList<>();
			}
			Money.MoneyBuilder result;
			return getIndex(allocatedNotional, _index, () -> {
						Money.MoneyBuilder newAllocatedNotional = Money.builder();
						return newAllocatedNotional;
					});
		}
		
		@Override
		@RosettaAttribute("allocationContentModel")
		public AllocationContentModel.AllocationContentModelBuilder getAllocationContentModel() {
			return allocationContentModel;
		}
		
		@Override
		public AllocationContentModel.AllocationContentModelBuilder getOrCreateAllocationContentModel() {
			AllocationContentModel.AllocationContentModelBuilder result;
			if (allocationContentModel!=null) {
				result = allocationContentModel;
			}
			else {
				result = allocationContentModel = AllocationContentModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocationTradeId")
		public Allocation.AllocationBuilder addAllocationTradeId(TradeIdentifier allocationTradeId) {
			if (allocationTradeId!=null) this.allocationTradeId.add(allocationTradeId.toBuilder());
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder addAllocationTradeId(TradeIdentifier allocationTradeId, int _idx) {
			getIndex(this.allocationTradeId, _idx, () -> allocationTradeId.toBuilder());
			return this;
		}
		@Override 
		public Allocation.AllocationBuilder addAllocationTradeId(List<? extends TradeIdentifier> allocationTradeIds) {
			if (allocationTradeIds != null) {
				for (TradeIdentifier toAdd : allocationTradeIds) {
					this.allocationTradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Allocation.AllocationBuilder setAllocationTradeId(List<? extends TradeIdentifier> allocationTradeIds) {
			if (allocationTradeIds == null)  {
				this.allocationTradeId = new ArrayList<>();
			}
			else {
				this.allocationTradeId = allocationTradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("partyAndAccountReferencesModel")
		public Allocation.AllocationBuilder setPartyAndAccountReferencesModel(PartyAndAccountReferencesModel partyAndAccountReferencesModel) {
			this.partyAndAccountReferencesModel = partyAndAccountReferencesModel==null?null:partyAndAccountReferencesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("allocatedFraction")
		public Allocation.AllocationBuilder setAllocatedFraction(BigDecimal allocatedFraction) {
			this.allocatedFraction = allocatedFraction==null?null:allocatedFraction;
			return this;
		}
		@Override
		@RosettaAttribute("allocatedNotional")
		public Allocation.AllocationBuilder addAllocatedNotional(Money allocatedNotional) {
			if (allocatedNotional!=null) this.allocatedNotional.add(allocatedNotional.toBuilder());
			return this;
		}
		
		@Override
		public Allocation.AllocationBuilder addAllocatedNotional(Money allocatedNotional, int _idx) {
			getIndex(this.allocatedNotional, _idx, () -> allocatedNotional.toBuilder());
			return this;
		}
		@Override 
		public Allocation.AllocationBuilder addAllocatedNotional(List<? extends Money> allocatedNotionals) {
			if (allocatedNotionals != null) {
				for (Money toAdd : allocatedNotionals) {
					this.allocatedNotional.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Allocation.AllocationBuilder setAllocatedNotional(List<? extends Money> allocatedNotionals) {
			if (allocatedNotionals == null)  {
				this.allocatedNotional = new ArrayList<>();
			}
			else {
				this.allocatedNotional = allocatedNotionals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("allocationContentModel")
		public Allocation.AllocationBuilder setAllocationContentModel(AllocationContentModel allocationContentModel) {
			this.allocationContentModel = allocationContentModel==null?null:allocationContentModel.toBuilder();
			return this;
		}
		
		@Override
		public Allocation build() {
			return new Allocation.AllocationImpl(this);
		}
		
		@Override
		public Allocation.AllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Allocation.AllocationBuilder prune() {
			allocationTradeId = allocationTradeId.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (partyAndAccountReferencesModel!=null && !partyAndAccountReferencesModel.prune().hasData()) partyAndAccountReferencesModel = null;
			allocatedNotional = allocatedNotional.stream().filter(b->b!=null).<Money.MoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (allocationContentModel!=null && !allocationContentModel.prune().hasData()) allocationContentModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocationTradeId()!=null && getAllocationTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyAndAccountReferencesModel()!=null && getPartyAndAccountReferencesModel().hasData()) return true;
			if (getAllocatedFraction()!=null) return true;
			if (getAllocatedNotional()!=null && getAllocatedNotional().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAllocationContentModel()!=null && getAllocationContentModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Allocation.AllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Allocation.AllocationBuilder o = (Allocation.AllocationBuilder) other;
			
			merger.mergeRosetta(getAllocationTradeId(), o.getAllocationTradeId(), this::getOrCreateAllocationTradeId);
			merger.mergeRosetta(getPartyAndAccountReferencesModel(), o.getPartyAndAccountReferencesModel(), this::setPartyAndAccountReferencesModel);
			merger.mergeRosetta(getAllocatedNotional(), o.getAllocatedNotional(), this::getOrCreateAllocatedNotional);
			merger.mergeRosetta(getAllocationContentModel(), o.getAllocationContentModel(), this::setAllocationContentModel);
			
			merger.mergeBasic(getAllocatedFraction(), o.getAllocatedFraction(), this::setAllocatedFraction);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Allocation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(allocationTradeId, _that.getAllocationTradeId())) return false;
			if (!Objects.equals(partyAndAccountReferencesModel, _that.getPartyAndAccountReferencesModel())) return false;
			if (!Objects.equals(allocatedFraction, _that.getAllocatedFraction())) return false;
			if (!ListEquals.listEquals(allocatedNotional, _that.getAllocatedNotional())) return false;
			if (!Objects.equals(allocationContentModel, _that.getAllocationContentModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocationTradeId != null ? allocationTradeId.hashCode() : 0);
			_result = 31 * _result + (partyAndAccountReferencesModel != null ? partyAndAccountReferencesModel.hashCode() : 0);
			_result = 31 * _result + (allocatedFraction != null ? allocatedFraction.hashCode() : 0);
			_result = 31 * _result + (allocatedNotional != null ? allocatedNotional.hashCode() : 0);
			_result = 31 * _result + (allocationContentModel != null ? allocationContentModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationBuilder {" +
				"allocationTradeId=" + this.allocationTradeId + ", " +
				"partyAndAccountReferencesModel=" + this.partyAndAccountReferencesModel + ", " +
				"allocatedFraction=" + this.allocatedFraction + ", " +
				"allocatedNotional=" + this.allocatedNotional + ", " +
				"allocationContentModel=" + this.allocationContentModel +
			'}';
		}
	}
}
