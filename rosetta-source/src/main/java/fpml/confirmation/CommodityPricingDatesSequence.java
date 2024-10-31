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
import fpml.confirmation.CommodityPricingDatesSequence;
import fpml.confirmation.CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder;
import fpml.confirmation.CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilderImpl;
import fpml.confirmation.CommodityPricingDatesSequence.CommodityPricingDatesSequenceImpl;
import fpml.confirmation.CommodityPricingDatesSequenceSequence;
import fpml.confirmation.Lag;
import fpml.confirmation.SettlementPeriods;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.meta.CommodityPricingDatesSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPricingDatesSequence", builder=CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityPricingDatesSequence extends RosettaModelObject {

	CommodityPricingDatesSequenceMeta metaData = new CommodityPricingDatesSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
	 */
	Lag getLag();
	CommodityPricingDatesSequenceSequence getCommodityPricingDatesSequenceSequence();
	/**
	 * Specifies a set of Settlement Periods associated with an Electricity Transaction for delivery on an Applicable Day or for a series of Applicable Days.
	 */
	List<? extends SettlementPeriods> getSettlementPeriods();
	/**
	 * Allows a set of Settlement Periods to reference one already defined elsewhere in the trade structure.
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	CommodityPricingDatesSequence build();
	
	CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder toBuilder();
	
	static CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder builder() {
		return new CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPricingDatesSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPricingDatesSequence> getType() {
		return CommodityPricingDatesSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lag"), processor, Lag.class, getLag());
		processRosetta(path.newSubPath("commodityPricingDatesSequenceSequence"), processor, CommodityPricingDatesSequenceSequence.class, getCommodityPricingDatesSequenceSequence());
		processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.class, getSettlementPeriods());
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPricingDatesSequenceBuilder extends CommodityPricingDatesSequence, RosettaModelObjectBuilder {
		Lag.LagBuilder getOrCreateLag();
		Lag.LagBuilder getLag();
		CommodityPricingDatesSequenceSequence.CommodityPricingDatesSequenceSequenceBuilder getOrCreateCommodityPricingDatesSequenceSequence();
		CommodityPricingDatesSequenceSequence.CommodityPricingDatesSequenceSequenceBuilder getCommodityPricingDatesSequenceSequence();
		SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int _index);
		List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods();
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder setLag(Lag lag);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder setCommodityPricingDatesSequenceSequence(CommodityPricingDatesSequenceSequence commodityPricingDatesSequenceSequence);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriods(SettlementPeriods settlementPeriods0);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriods(SettlementPeriods settlementPeriods1, int _idx);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods2);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods3);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lag"), processor, Lag.LagBuilder.class, getLag());
			processRosetta(path.newSubPath("commodityPricingDatesSequenceSequence"), processor, CommodityPricingDatesSequenceSequence.CommodityPricingDatesSequenceSequenceBuilder.class, getCommodityPricingDatesSequenceSequence());
			processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.SettlementPeriodsBuilder.class, getSettlementPeriods());
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPricingDatesSequence  ***********************/
	class CommodityPricingDatesSequenceImpl implements CommodityPricingDatesSequence {
		private final Lag lag;
		private final CommodityPricingDatesSequenceSequence commodityPricingDatesSequenceSequence;
		private final List<? extends SettlementPeriods> settlementPeriods;
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected CommodityPricingDatesSequenceImpl(CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder builder) {
			this.lag = ofNullable(builder.getLag()).map(f->f.build()).orElse(null);
			this.commodityPricingDatesSequenceSequence = ofNullable(builder.getCommodityPricingDatesSequenceSequence()).map(f->f.build()).orElse(null);
			this.settlementPeriods = ofNullable(builder.getSettlementPeriods()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lag")
		public Lag getLag() {
			return lag;
		}
		
		@Override
		@RosettaAttribute("commodityPricingDatesSequenceSequence")
		public CommodityPricingDatesSequenceSequence getCommodityPricingDatesSequenceSequence() {
			return commodityPricingDatesSequenceSequence;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		public List<? extends SettlementPeriods> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
		public CommodityPricingDatesSequence build() {
			return this;
		}
		
		@Override
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder toBuilder() {
			CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder builder) {
			ofNullable(getLag()).ifPresent(builder::setLag);
			ofNullable(getCommodityPricingDatesSequenceSequence()).ifPresent(builder::setCommodityPricingDatesSequenceSequence);
			ofNullable(getSettlementPeriods()).ifPresent(builder::setSettlementPeriods);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPricingDatesSequence _that = getType().cast(o);
		
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(commodityPricingDatesSequenceSequence, _that.getCommodityPricingDatesSequenceSequence())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (commodityPricingDatesSequenceSequence != null ? commodityPricingDatesSequenceSequence.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPricingDatesSequence {" +
				"lag=" + this.lag + ", " +
				"commodityPricingDatesSequenceSequence=" + this.commodityPricingDatesSequenceSequence + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPricingDatesSequence  ***********************/
	class CommodityPricingDatesSequenceBuilderImpl implements CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder {
	
		protected Lag.LagBuilder lag;
		protected CommodityPricingDatesSequenceSequence.CommodityPricingDatesSequenceSequenceBuilder commodityPricingDatesSequenceSequence;
		protected List<SettlementPeriods.SettlementPeriodsBuilder> settlementPeriods = new ArrayList<>();
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public CommodityPricingDatesSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lag")
		public Lag.LagBuilder getLag() {
			return lag;
		}
		
		@Override
		public Lag.LagBuilder getOrCreateLag() {
			Lag.LagBuilder result;
			if (lag!=null) {
				result = lag;
			}
			else {
				result = lag = Lag.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPricingDatesSequenceSequence")
		public CommodityPricingDatesSequenceSequence.CommodityPricingDatesSequenceSequenceBuilder getCommodityPricingDatesSequenceSequence() {
			return commodityPricingDatesSequenceSequence;
		}
		
		@Override
		public CommodityPricingDatesSequenceSequence.CommodityPricingDatesSequenceSequenceBuilder getOrCreateCommodityPricingDatesSequenceSequence() {
			CommodityPricingDatesSequenceSequence.CommodityPricingDatesSequenceSequenceBuilder result;
			if (commodityPricingDatesSequenceSequence!=null) {
				result = commodityPricingDatesSequenceSequence;
			}
			else {
				result = commodityPricingDatesSequenceSequence = CommodityPricingDatesSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		public List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int _index) {
		
			if (settlementPeriods==null) {
				this.settlementPeriods = new ArrayList<>();
			}
			SettlementPeriods.SettlementPeriodsBuilder result;
			return getIndex(settlementPeriods, _index, () -> {
						SettlementPeriods.SettlementPeriodsBuilder newSettlementPeriods = SettlementPeriods.builder();
						return newSettlementPeriods;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference() {
			return settlementPeriodsReference;
		}
		
		@Override
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
		@RosettaAttribute("lag")
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder setLag(Lag lag) {
			this.lag = lag==null?null:lag.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPricingDatesSequenceSequence")
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder setCommodityPricingDatesSequenceSequence(CommodityPricingDatesSequenceSequence commodityPricingDatesSequenceSequence) {
			this.commodityPricingDatesSequenceSequence = commodityPricingDatesSequenceSequence==null?null:commodityPricingDatesSequenceSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementPeriods")
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriods(SettlementPeriods settlementPeriods) {
			if (settlementPeriods!=null) this.settlementPeriods.add(settlementPeriods.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriods(SettlementPeriods settlementPeriods, int _idx) {
			getIndex(this.settlementPeriods, _idx, () -> settlementPeriods.toBuilder());
			return this;
		}
		@Override 
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss != null) {
				for (SettlementPeriods toAdd : settlementPeriodss) {
					this.settlementPeriods.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss == null)  {
				this.settlementPeriods = new ArrayList<>();
			}
			else {
				this.settlementPeriods = settlementPeriodss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsReference")
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
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
		public CommodityPricingDatesSequence build() {
			return new CommodityPricingDatesSequence.CommodityPricingDatesSequenceImpl(this);
		}
		
		@Override
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder prune() {
			if (lag!=null && !lag.prune().hasData()) lag = null;
			if (commodityPricingDatesSequenceSequence!=null && !commodityPricingDatesSequenceSequence.prune().hasData()) commodityPricingDatesSequenceSequence = null;
			settlementPeriods = settlementPeriods.stream().filter(b->b!=null).<SettlementPeriods.SettlementPeriodsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLag()!=null && getLag().hasData()) return true;
			if (getCommodityPricingDatesSequenceSequence()!=null && getCommodityPricingDatesSequenceSequence().hasData()) return true;
			if (getSettlementPeriods()!=null && getSettlementPeriods().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder o = (CommodityPricingDatesSequence.CommodityPricingDatesSequenceBuilder) other;
			
			merger.mergeRosetta(getLag(), o.getLag(), this::setLag);
			merger.mergeRosetta(getCommodityPricingDatesSequenceSequence(), o.getCommodityPricingDatesSequenceSequence(), this::setCommodityPricingDatesSequenceSequence);
			merger.mergeRosetta(getSettlementPeriods(), o.getSettlementPeriods(), this::getOrCreateSettlementPeriods);
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPricingDatesSequence _that = getType().cast(o);
		
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(commodityPricingDatesSequenceSequence, _that.getCommodityPricingDatesSequenceSequence())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (commodityPricingDatesSequenceSequence != null ? commodityPricingDatesSequenceSequence.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPricingDatesSequenceBuilder {" +
				"lag=" + this.lag + ", " +
				"commodityPricingDatesSequenceSequence=" + this.commodityPricingDatesSequenceSequence + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}
}
