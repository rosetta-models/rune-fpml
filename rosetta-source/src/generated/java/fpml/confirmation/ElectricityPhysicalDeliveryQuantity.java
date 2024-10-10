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
import fpml.confirmation.CommodityNotionalQuantity;
import fpml.confirmation.CommodityNotionalQuantity.CommodityNotionalQuantityBuilder;
import fpml.confirmation.CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl;
import fpml.confirmation.CommodityNotionalQuantity.CommodityNotionalQuantityImpl;
import fpml.confirmation.CommodityQuantityFrequency;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantity;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilderImpl;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityImpl;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.meta.ElectricityPhysicalDeliveryQuantityMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the physical quantity of the electricity to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityPhysicalDeliveryQuantity", builder=ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilderImpl.class, version="${project.version}")
public interface ElectricityPhysicalDeliveryQuantity extends CommodityNotionalQuantity {

	ElectricityPhysicalDeliveryQuantityMeta metaData = new ElectricityPhysicalDeliveryQuantityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the range(s) of Settlement Periods to which this quantity applies.
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	ElectricityPhysicalDeliveryQuantity build();
	
	ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder toBuilder();
	
	static ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder builder() {
		return new ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityPhysicalDeliveryQuantity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityPhysicalDeliveryQuantity> getType() {
		return ElectricityPhysicalDeliveryQuantity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.class, getQuantityUnit());
		processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.class, getQuantityFrequency());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityPhysicalDeliveryQuantityBuilder extends ElectricityPhysicalDeliveryQuantity, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantity(BigDecimal quantity);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setId(String id);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder.class, getQuantityFrequency());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityPhysicalDeliveryQuantity  ***********************/
	class ElectricityPhysicalDeliveryQuantityImpl extends CommodityNotionalQuantity.CommodityNotionalQuantityImpl implements ElectricityPhysicalDeliveryQuantity {
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected ElectricityPhysicalDeliveryQuantityImpl(ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder builder) {
			super(builder);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity build() {
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder toBuilder() {
			ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalDeliveryQuantity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalDeliveryQuantity {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ElectricityPhysicalDeliveryQuantity  ***********************/
	class ElectricityPhysicalDeliveryQuantityBuilderImpl extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl  implements ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder {
	
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public ElectricityPhysicalDeliveryQuantityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		public SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index) {
		
			if (settlementPeriodsReference==null) {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			SettlementPeriodsReference.SettlementPeriodsReferenceBuilder result;
			return getIndex(settlementPeriodsReference, _index, () -> {
						SettlementPeriodsReference.SettlementPeriodsReferenceBuilder newSettlementPeriodsReference = SettlementPeriodsReference.builder();
						return newSettlementPeriodsReference;
					});
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit) {
			this.quantityUnit = quantityUnit==null?null:quantityUnit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantityFrequency")
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency) {
			this.quantityFrequency = quantityFrequency==null?null:quantityFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantity")
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsReference")
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences == null)  {
				this.settlementPeriodsReference = new ArrayList<>();
			}
			else {
				this.settlementPeriodsReference = settlementPeriodsReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ElectricityPhysicalDeliveryQuantity build() {
			return new ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityImpl(this);
		}
		
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder prune() {
			super.prune();
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder o = (ElectricityPhysicalDeliveryQuantity.ElectricityPhysicalDeliveryQuantityBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalDeliveryQuantity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalDeliveryQuantityBuilder {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}
}
