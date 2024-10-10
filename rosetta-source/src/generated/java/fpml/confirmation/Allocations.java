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
import fpml.confirmation.Allocations;
import fpml.confirmation.Allocations.AllocationsBuilder;
import fpml.confirmation.Allocations.AllocationsBuilderImpl;
import fpml.confirmation.Allocations.AllocationsImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.AllocationsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The allocations for a single side of a trade.
 * @version ${project.version}
 */
@RosettaDataType(value="Allocations", builder=Allocations.AllocationsBuilderImpl.class, version="${project.version}")
public interface Allocations extends RosettaModelObject {

	AllocationsMeta metaData = new AllocationsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to one of the parties to the trade, defined elsewhere in the document. The party referenced has requested its position in the trade to be allocated to several other parties or accounts.
	 */
	PartyReference getAllocatingPartyReference();
	List<? extends Allocation> getAllocation();

	/*********************** Build Methods  ***********************/
	Allocations build();
	
	Allocations.AllocationsBuilder toBuilder();
	
	static Allocations.AllocationsBuilder builder() {
		return new Allocations.AllocationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Allocations> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Allocations> getType() {
		return Allocations.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("allocatingPartyReference"), processor, PartyReference.class, getAllocatingPartyReference());
		processRosetta(path.newSubPath("allocation"), processor, Allocation.class, getAllocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AllocationsBuilder extends Allocations, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateAllocatingPartyReference();
		PartyReference.PartyReferenceBuilder getAllocatingPartyReference();
		Allocation.AllocationBuilder getOrCreateAllocation(int _index);
		List<? extends Allocation.AllocationBuilder> getAllocation();
		Allocations.AllocationsBuilder setAllocatingPartyReference(PartyReference allocatingPartyReference);
		Allocations.AllocationsBuilder addAllocation(Allocation allocation0);
		Allocations.AllocationsBuilder addAllocation(Allocation allocation1, int _idx);
		Allocations.AllocationsBuilder addAllocation(List<? extends Allocation> allocation2);
		Allocations.AllocationsBuilder setAllocation(List<? extends Allocation> allocation3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("allocatingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAllocatingPartyReference());
			processRosetta(path.newSubPath("allocation"), processor, Allocation.AllocationBuilder.class, getAllocation());
		}
		

		Allocations.AllocationsBuilder prune();
	}

	/*********************** Immutable Implementation of Allocations  ***********************/
	class AllocationsImpl implements Allocations {
		private final PartyReference allocatingPartyReference;
		private final List<? extends Allocation> allocation;
		
		protected AllocationsImpl(Allocations.AllocationsBuilder builder) {
			this.allocatingPartyReference = ofNullable(builder.getAllocatingPartyReference()).map(f->f.build()).orElse(null);
			this.allocation = ofNullable(builder.getAllocation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("allocatingPartyReference")
		public PartyReference getAllocatingPartyReference() {
			return allocatingPartyReference;
		}
		
		@Override
		@RosettaAttribute("allocation")
		public List<? extends Allocation> getAllocation() {
			return allocation;
		}
		
		@Override
		public Allocations build() {
			return this;
		}
		
		@Override
		public Allocations.AllocationsBuilder toBuilder() {
			Allocations.AllocationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Allocations.AllocationsBuilder builder) {
			ofNullable(getAllocatingPartyReference()).ifPresent(builder::setAllocatingPartyReference);
			ofNullable(getAllocation()).ifPresent(builder::setAllocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Allocations _that = getType().cast(o);
		
			if (!Objects.equals(allocatingPartyReference, _that.getAllocatingPartyReference())) return false;
			if (!ListEquals.listEquals(allocation, _that.getAllocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocatingPartyReference != null ? allocatingPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocation != null ? allocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Allocations {" +
				"allocatingPartyReference=" + this.allocatingPartyReference + ", " +
				"allocation=" + this.allocation +
			'}';
		}
	}

	/*********************** Builder Implementation of Allocations  ***********************/
	class AllocationsBuilderImpl implements Allocations.AllocationsBuilder {
	
		protected PartyReference.PartyReferenceBuilder allocatingPartyReference;
		protected List<Allocation.AllocationBuilder> allocation = new ArrayList<>();
	
		public AllocationsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("allocatingPartyReference")
		public PartyReference.PartyReferenceBuilder getAllocatingPartyReference() {
			return allocatingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAllocatingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (allocatingPartyReference!=null) {
				result = allocatingPartyReference;
			}
			else {
				result = allocatingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("allocation")
		public List<? extends Allocation.AllocationBuilder> getAllocation() {
			return allocation;
		}
		
		public Allocation.AllocationBuilder getOrCreateAllocation(int _index) {
		
			if (allocation==null) {
				this.allocation = new ArrayList<>();
			}
			Allocation.AllocationBuilder result;
			return getIndex(allocation, _index, () -> {
						Allocation.AllocationBuilder newAllocation = Allocation.builder();
						return newAllocation;
					});
		}
		
		@Override
		@RosettaAttribute("allocatingPartyReference")
		public Allocations.AllocationsBuilder setAllocatingPartyReference(PartyReference allocatingPartyReference) {
			this.allocatingPartyReference = allocatingPartyReference==null?null:allocatingPartyReference.toBuilder();
			return this;
		}
		@Override
		public Allocations.AllocationsBuilder addAllocation(Allocation allocation) {
			if (allocation!=null) this.allocation.add(allocation.toBuilder());
			return this;
		}
		
		@Override
		public Allocations.AllocationsBuilder addAllocation(Allocation allocation, int _idx) {
			getIndex(this.allocation, _idx, () -> allocation.toBuilder());
			return this;
		}
		@Override 
		public Allocations.AllocationsBuilder addAllocation(List<? extends Allocation> allocations) {
			if (allocations != null) {
				for (Allocation toAdd : allocations) {
					this.allocation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("allocation")
		public Allocations.AllocationsBuilder setAllocation(List<? extends Allocation> allocations) {
			if (allocations == null)  {
				this.allocation = new ArrayList<>();
			}
			else {
				this.allocation = allocations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Allocations build() {
			return new Allocations.AllocationsImpl(this);
		}
		
		@Override
		public Allocations.AllocationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Allocations.AllocationsBuilder prune() {
			if (allocatingPartyReference!=null && !allocatingPartyReference.prune().hasData()) allocatingPartyReference = null;
			allocation = allocation.stream().filter(b->b!=null).<Allocation.AllocationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAllocatingPartyReference()!=null && getAllocatingPartyReference().hasData()) return true;
			if (getAllocation()!=null && getAllocation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Allocations.AllocationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Allocations.AllocationsBuilder o = (Allocations.AllocationsBuilder) other;
			
			merger.mergeRosetta(getAllocatingPartyReference(), o.getAllocatingPartyReference(), this::setAllocatingPartyReference);
			merger.mergeRosetta(getAllocation(), o.getAllocation(), this::getOrCreateAllocation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Allocations _that = getType().cast(o);
		
			if (!Objects.equals(allocatingPartyReference, _that.getAllocatingPartyReference())) return false;
			if (!ListEquals.listEquals(allocation, _that.getAllocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (allocatingPartyReference != null ? allocatingPartyReference.hashCode() : 0);
			_result = 31 * _result + (allocation != null ? allocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AllocationsBuilder {" +
				"allocatingPartyReference=" + this.allocatingPartyReference + ", " +
				"allocation=" + this.allocation +
			'}';
		}
	}
}
