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
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantity;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilderImpl;
import fpml.confirmation.CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityImpl;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.meta.CommoditySettlementPeriodsNotionalQuantityMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The notional quantity of electricity that applies to one or more groups of Settlement Periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommoditySettlementPeriodsNotionalQuantity", builder=CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilderImpl.class, version="${project.version}")
public interface CommoditySettlementPeriodsNotionalQuantity extends CommodityNotionalQuantity {

	CommoditySettlementPeriodsNotionalQuantityMeta metaData = new CommoditySettlementPeriodsNotionalQuantityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The range(s) of Settlement Periods to which the Notional Quantity applies.
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	CommoditySettlementPeriodsNotionalQuantity build();
	
	CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder toBuilder();
	
	static CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder builder() {
		return new CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySettlementPeriodsNotionalQuantity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySettlementPeriodsNotionalQuantity> getType() {
		return CommoditySettlementPeriodsNotionalQuantity.class;
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
	interface CommoditySettlementPeriodsNotionalQuantityBuilder extends CommoditySettlementPeriodsNotionalQuantity, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder {
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit);
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency);
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setQuantity(BigDecimal quantity);
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setId(String id);
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processRosetta(path.newSubPath("quantityFrequency"), processor, CommodityQuantityFrequency.CommodityQuantityFrequencyBuilder.class, getQuantityFrequency());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySettlementPeriodsNotionalQuantity  ***********************/
	class CommoditySettlementPeriodsNotionalQuantityImpl extends CommodityNotionalQuantity.CommodityNotionalQuantityImpl implements CommoditySettlementPeriodsNotionalQuantity {
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected CommoditySettlementPeriodsNotionalQuantityImpl(CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder builder) {
			super(builder);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantity build() {
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder toBuilder() {
			CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySettlementPeriodsNotionalQuantity _that = getType().cast(o);
		
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
			return "CommoditySettlementPeriodsNotionalQuantity {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommoditySettlementPeriodsNotionalQuantity  ***********************/
	class CommoditySettlementPeriodsNotionalQuantityBuilderImpl extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilderImpl  implements CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder {
	
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public CommoditySettlementPeriodsNotionalQuantityBuilderImpl() {
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
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setQuantityUnit(QuantityUnit quantityUnit) {
			this.quantityUnit = quantityUnit==null?null:quantityUnit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantityFrequency")
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setQuantityFrequency(CommodityQuantityFrequency quantityFrequency) {
			this.quantityFrequency = quantityFrequency==null?null:quantityFrequency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quantity")
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setQuantity(BigDecimal quantity) {
			this.quantity = quantity==null?null:quantity;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsReference")
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
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
		public CommoditySettlementPeriodsNotionalQuantity build() {
			return new CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityImpl(this);
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder prune() {
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
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder o = (CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySettlementPeriodsNotionalQuantity _that = getType().cast(o);
		
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
			return "CommoditySettlementPeriodsNotionalQuantityBuilder {" +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}' + " " + super.toString();
		}
	}
}
