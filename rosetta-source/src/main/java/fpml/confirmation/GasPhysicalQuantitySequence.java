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
import fpml.confirmation.GasPhysicalQuantitySequence;
import fpml.confirmation.GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder;
import fpml.confirmation.GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilderImpl;
import fpml.confirmation.GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.GasPhysicalQuantitySequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GasPhysicalQuantitySequence", builder=GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilderImpl.class, version="${project.version}")
public interface GasPhysicalQuantitySequence extends RosettaModelObject {

	GasPhysicalQuantitySequenceMeta metaData = new GasPhysicalQuantitySequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The minimum quantity to be delivered. If separate minimums need to be specified for different periods (e.g. a minimum per day and a minimum per month) this element should be repeated.
	 */
	List<? extends CommodityNotionalQuantity> getMinPhysicalQuantity();
	/**
	 * The maximum quantity to be delivered. If separate minimums need to be specified for different periods (e.g. a minimum per day and a minimum per month) this element should be repeated.
	 */
	List<? extends CommodityNotionalQuantity> getMaxPhysicalQuantity();
	/**
	 * Indicates the party able to choose whether the gas is delivered for a particular period e.g. a swing or interruptible contract.
	 */
	PartyReference getElectingParty();

	/*********************** Build Methods  ***********************/
	GasPhysicalQuantitySequence build();
	
	GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder toBuilder();
	
	static GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder builder() {
		return new GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasPhysicalQuantitySequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasPhysicalQuantitySequence> getType() {
		return GasPhysicalQuantitySequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("minPhysicalQuantity"), processor, CommodityNotionalQuantity.class, getMinPhysicalQuantity());
		processRosetta(path.newSubPath("maxPhysicalQuantity"), processor, CommodityNotionalQuantity.class, getMaxPhysicalQuantity());
		processRosetta(path.newSubPath("electingParty"), processor, PartyReference.class, getElectingParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasPhysicalQuantitySequenceBuilder extends GasPhysicalQuantitySequence, RosettaModelObjectBuilder {
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMinPhysicalQuantity(int _index);
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getMinPhysicalQuantity();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMaxPhysicalQuantity(int _index);
		List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getMaxPhysicalQuantity();
		PartyReference.PartyReferenceBuilder getOrCreateElectingParty();
		PartyReference.PartyReferenceBuilder getElectingParty();
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMinPhysicalQuantity(CommodityNotionalQuantity minPhysicalQuantity0);
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMinPhysicalQuantity(CommodityNotionalQuantity minPhysicalQuantity1, int _idx);
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMinPhysicalQuantity(List<? extends CommodityNotionalQuantity> minPhysicalQuantity2);
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder setMinPhysicalQuantity(List<? extends CommodityNotionalQuantity> minPhysicalQuantity3);
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMaxPhysicalQuantity(CommodityNotionalQuantity maxPhysicalQuantity0);
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMaxPhysicalQuantity(CommodityNotionalQuantity maxPhysicalQuantity1, int _idx);
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMaxPhysicalQuantity(List<? extends CommodityNotionalQuantity> maxPhysicalQuantity2);
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder setMaxPhysicalQuantity(List<? extends CommodityNotionalQuantity> maxPhysicalQuantity3);
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder setElectingParty(PartyReference electingParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("minPhysicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getMinPhysicalQuantity());
			processRosetta(path.newSubPath("maxPhysicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getMaxPhysicalQuantity());
			processRosetta(path.newSubPath("electingParty"), processor, PartyReference.PartyReferenceBuilder.class, getElectingParty());
		}
		

		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder prune();
	}

	/*********************** Immutable Implementation of GasPhysicalQuantitySequence  ***********************/
	class GasPhysicalQuantitySequenceImpl implements GasPhysicalQuantitySequence {
		private final List<? extends CommodityNotionalQuantity> minPhysicalQuantity;
		private final List<? extends CommodityNotionalQuantity> maxPhysicalQuantity;
		private final PartyReference electingParty;
		
		protected GasPhysicalQuantitySequenceImpl(GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder builder) {
			this.minPhysicalQuantity = ofNullable(builder.getMinPhysicalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.maxPhysicalQuantity = ofNullable(builder.getMaxPhysicalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.electingParty = ofNullable(builder.getElectingParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("minPhysicalQuantity")
		public List<? extends CommodityNotionalQuantity> getMinPhysicalQuantity() {
			return minPhysicalQuantity;
		}
		
		@Override
		@RosettaAttribute("maxPhysicalQuantity")
		public List<? extends CommodityNotionalQuantity> getMaxPhysicalQuantity() {
			return maxPhysicalQuantity;
		}
		
		@Override
		@RosettaAttribute("electingParty")
		public PartyReference getElectingParty() {
			return electingParty;
		}
		
		@Override
		public GasPhysicalQuantitySequence build() {
			return this;
		}
		
		@Override
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder toBuilder() {
			GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder builder) {
			ofNullable(getMinPhysicalQuantity()).ifPresent(builder::setMinPhysicalQuantity);
			ofNullable(getMaxPhysicalQuantity()).ifPresent(builder::setMaxPhysicalQuantity);
			ofNullable(getElectingParty()).ifPresent(builder::setElectingParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasPhysicalQuantitySequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(minPhysicalQuantity, _that.getMinPhysicalQuantity())) return false;
			if (!ListEquals.listEquals(maxPhysicalQuantity, _that.getMaxPhysicalQuantity())) return false;
			if (!Objects.equals(electingParty, _that.getElectingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (minPhysicalQuantity != null ? minPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (maxPhysicalQuantity != null ? maxPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (electingParty != null ? electingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalQuantitySequence {" +
				"minPhysicalQuantity=" + this.minPhysicalQuantity + ", " +
				"maxPhysicalQuantity=" + this.maxPhysicalQuantity + ", " +
				"electingParty=" + this.electingParty +
			'}';
		}
	}

	/*********************** Builder Implementation of GasPhysicalQuantitySequence  ***********************/
	class GasPhysicalQuantitySequenceBuilderImpl implements GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder {
	
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> minPhysicalQuantity = new ArrayList<>();
		protected List<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> maxPhysicalQuantity = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder electingParty;
	
		public GasPhysicalQuantitySequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("minPhysicalQuantity")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getMinPhysicalQuantity() {
			return minPhysicalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMinPhysicalQuantity(int _index) {
		
			if (minPhysicalQuantity==null) {
				this.minPhysicalQuantity = new ArrayList<>();
			}
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			return getIndex(minPhysicalQuantity, _index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newMinPhysicalQuantity = CommodityNotionalQuantity.builder();
						return newMinPhysicalQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("maxPhysicalQuantity")
		public List<? extends CommodityNotionalQuantity.CommodityNotionalQuantityBuilder> getMaxPhysicalQuantity() {
			return maxPhysicalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateMaxPhysicalQuantity(int _index) {
		
			if (maxPhysicalQuantity==null) {
				this.maxPhysicalQuantity = new ArrayList<>();
			}
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			return getIndex(maxPhysicalQuantity, _index, () -> {
						CommodityNotionalQuantity.CommodityNotionalQuantityBuilder newMaxPhysicalQuantity = CommodityNotionalQuantity.builder();
						return newMaxPhysicalQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("electingParty")
		public PartyReference.PartyReferenceBuilder getElectingParty() {
			return electingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateElectingParty() {
			PartyReference.PartyReferenceBuilder result;
			if (electingParty!=null) {
				result = electingParty;
			}
			else {
				result = electingParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minPhysicalQuantity")
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMinPhysicalQuantity(CommodityNotionalQuantity minPhysicalQuantity) {
			if (minPhysicalQuantity!=null) this.minPhysicalQuantity.add(minPhysicalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMinPhysicalQuantity(CommodityNotionalQuantity minPhysicalQuantity, int _idx) {
			getIndex(this.minPhysicalQuantity, _idx, () -> minPhysicalQuantity.toBuilder());
			return this;
		}
		@Override 
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMinPhysicalQuantity(List<? extends CommodityNotionalQuantity> minPhysicalQuantitys) {
			if (minPhysicalQuantitys != null) {
				for (CommodityNotionalQuantity toAdd : minPhysicalQuantitys) {
					this.minPhysicalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder setMinPhysicalQuantity(List<? extends CommodityNotionalQuantity> minPhysicalQuantitys) {
			if (minPhysicalQuantitys == null)  {
				this.minPhysicalQuantity = new ArrayList<>();
			}
			else {
				this.minPhysicalQuantity = minPhysicalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("maxPhysicalQuantity")
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMaxPhysicalQuantity(CommodityNotionalQuantity maxPhysicalQuantity) {
			if (maxPhysicalQuantity!=null) this.maxPhysicalQuantity.add(maxPhysicalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMaxPhysicalQuantity(CommodityNotionalQuantity maxPhysicalQuantity, int _idx) {
			getIndex(this.maxPhysicalQuantity, _idx, () -> maxPhysicalQuantity.toBuilder());
			return this;
		}
		@Override 
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder addMaxPhysicalQuantity(List<? extends CommodityNotionalQuantity> maxPhysicalQuantitys) {
			if (maxPhysicalQuantitys != null) {
				for (CommodityNotionalQuantity toAdd : maxPhysicalQuantitys) {
					this.maxPhysicalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder setMaxPhysicalQuantity(List<? extends CommodityNotionalQuantity> maxPhysicalQuantitys) {
			if (maxPhysicalQuantitys == null)  {
				this.maxPhysicalQuantity = new ArrayList<>();
			}
			else {
				this.maxPhysicalQuantity = maxPhysicalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("electingParty")
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder setElectingParty(PartyReference electingParty) {
			this.electingParty = electingParty==null?null:electingParty.toBuilder();
			return this;
		}
		
		@Override
		public GasPhysicalQuantitySequence build() {
			return new GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceImpl(this);
		}
		
		@Override
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder prune() {
			minPhysicalQuantity = minPhysicalQuantity.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			maxPhysicalQuantity = maxPhysicalQuantity.stream().filter(b->b!=null).<CommodityNotionalQuantity.CommodityNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (electingParty!=null && !electingParty.prune().hasData()) electingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMinPhysicalQuantity()!=null && getMinPhysicalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMaxPhysicalQuantity()!=null && getMaxPhysicalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getElectingParty()!=null && getElectingParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder o = (GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder) other;
			
			merger.mergeRosetta(getMinPhysicalQuantity(), o.getMinPhysicalQuantity(), this::getOrCreateMinPhysicalQuantity);
			merger.mergeRosetta(getMaxPhysicalQuantity(), o.getMaxPhysicalQuantity(), this::getOrCreateMaxPhysicalQuantity);
			merger.mergeRosetta(getElectingParty(), o.getElectingParty(), this::setElectingParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasPhysicalQuantitySequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(minPhysicalQuantity, _that.getMinPhysicalQuantity())) return false;
			if (!ListEquals.listEquals(maxPhysicalQuantity, _that.getMaxPhysicalQuantity())) return false;
			if (!Objects.equals(electingParty, _that.getElectingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (minPhysicalQuantity != null ? minPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (maxPhysicalQuantity != null ? maxPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (electingParty != null ? electingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalQuantitySequenceBuilder {" +
				"minPhysicalQuantity=" + this.minPhysicalQuantity + ", " +
				"maxPhysicalQuantity=" + this.maxPhysicalQuantity + ", " +
				"electingParty=" + this.electingParty +
			'}';
		}
	}
}
