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
import fpml.confirmation.CommodityValuationDatesSequence;
import fpml.confirmation.CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder;
import fpml.confirmation.CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilderImpl;
import fpml.confirmation.CommodityValuationDatesSequence.CommodityValuationDatesSequenceImpl;
import fpml.confirmation.CommodityValuationDatesSequenceSequence;
import fpml.confirmation.Lag;
import fpml.confirmation.SettlementPeriods;
import fpml.confirmation.SettlementPeriodsReference;
import fpml.confirmation.meta.CommodityValuationDatesSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityValuationDatesSequence", builder=CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityValuationDatesSequence extends RosettaModelObject {

	CommodityValuationDatesSequenceMeta metaData = new CommodityValuationDatesSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
	 */
	Lag getLag();
	CommodityValuationDatesSequenceSequence getCommodityValuationDatesSequenceSequence();
	/**
	 * Specifies a set of Settlement Periods associated with an Electricity Transaction for delivery on an Applicable Day or for a series of Applicable Days.
	 */
	List<? extends SettlementPeriods> getSettlementPeriods();
	/**
	 * Allows a set of Settlement Periods to reference one already defined elsewhere in the trade structure.
	 */
	List<? extends SettlementPeriodsReference> getSettlementPeriodsReference();

	/*********************** Build Methods  ***********************/
	CommodityValuationDatesSequence build();
	
	CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder toBuilder();
	
	static CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder builder() {
		return new CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityValuationDatesSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityValuationDatesSequence> getType() {
		return CommodityValuationDatesSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lag"), processor, Lag.class, getLag());
		processRosetta(path.newSubPath("commodityValuationDatesSequenceSequence"), processor, CommodityValuationDatesSequenceSequence.class, getCommodityValuationDatesSequenceSequence());
		processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.class, getSettlementPeriods());
		processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.class, getSettlementPeriodsReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityValuationDatesSequenceBuilder extends CommodityValuationDatesSequence, RosettaModelObjectBuilder {
		Lag.LagBuilder getOrCreateLag();
		Lag.LagBuilder getLag();
		CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder getOrCreateCommodityValuationDatesSequenceSequence();
		CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder getCommodityValuationDatesSequenceSequence();
		SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int _index);
		List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods();
		SettlementPeriodsReference.SettlementPeriodsReferenceBuilder getOrCreateSettlementPeriodsReference(int _index);
		List<? extends SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> getSettlementPeriodsReference();
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder setLag(Lag lag);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder setCommodityValuationDatesSequenceSequence(CommodityValuationDatesSequenceSequence commodityValuationDatesSequenceSequence);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriods(SettlementPeriods settlementPeriods0);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriods(SettlementPeriods settlementPeriods1, int _idx);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods2);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods3);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference0);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference1, int _idx);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference2);
		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lag"), processor, Lag.LagBuilder.class, getLag());
			processRosetta(path.newSubPath("commodityValuationDatesSequenceSequence"), processor, CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder.class, getCommodityValuationDatesSequenceSequence());
			processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.SettlementPeriodsBuilder.class, getSettlementPeriods());
			processRosetta(path.newSubPath("settlementPeriodsReference"), processor, SettlementPeriodsReference.SettlementPeriodsReferenceBuilder.class, getSettlementPeriodsReference());
		}
		

		CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityValuationDatesSequence  ***********************/
	class CommodityValuationDatesSequenceImpl implements CommodityValuationDatesSequence {
		private final Lag lag;
		private final CommodityValuationDatesSequenceSequence commodityValuationDatesSequenceSequence;
		private final List<? extends SettlementPeriods> settlementPeriods;
		private final List<? extends SettlementPeriodsReference> settlementPeriodsReference;
		
		protected CommodityValuationDatesSequenceImpl(CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder builder) {
			this.lag = ofNullable(builder.getLag()).map(f->f.build()).orElse(null);
			this.commodityValuationDatesSequenceSequence = ofNullable(builder.getCommodityValuationDatesSequenceSequence()).map(f->f.build()).orElse(null);
			this.settlementPeriods = ofNullable(builder.getSettlementPeriods()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsReference = ofNullable(builder.getSettlementPeriodsReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lag")
		public Lag getLag() {
			return lag;
		}
		
		@Override
		@RosettaAttribute("commodityValuationDatesSequenceSequence")
		public CommodityValuationDatesSequenceSequence getCommodityValuationDatesSequenceSequence() {
			return commodityValuationDatesSequenceSequence;
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
		public CommodityValuationDatesSequence build() {
			return this;
		}
		
		@Override
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder toBuilder() {
			CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder builder) {
			ofNullable(getLag()).ifPresent(builder::setLag);
			ofNullable(getCommodityValuationDatesSequenceSequence()).ifPresent(builder::setCommodityValuationDatesSequenceSequence);
			ofNullable(getSettlementPeriods()).ifPresent(builder::setSettlementPeriods);
			ofNullable(getSettlementPeriodsReference()).ifPresent(builder::setSettlementPeriodsReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityValuationDatesSequence _that = getType().cast(o);
		
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(commodityValuationDatesSequenceSequence, _that.getCommodityValuationDatesSequenceSequence())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (commodityValuationDatesSequenceSequence != null ? commodityValuationDatesSequenceSequence.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityValuationDatesSequence {" +
				"lag=" + this.lag + ", " +
				"commodityValuationDatesSequenceSequence=" + this.commodityValuationDatesSequenceSequence + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityValuationDatesSequence  ***********************/
	class CommodityValuationDatesSequenceBuilderImpl implements CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder {
	
		protected Lag.LagBuilder lag;
		protected CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder commodityValuationDatesSequenceSequence;
		protected List<SettlementPeriods.SettlementPeriodsBuilder> settlementPeriods = new ArrayList<>();
		protected List<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder> settlementPeriodsReference = new ArrayList<>();
	
		public CommodityValuationDatesSequenceBuilderImpl() {
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
		@RosettaAttribute("commodityValuationDatesSequenceSequence")
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder getCommodityValuationDatesSequenceSequence() {
			return commodityValuationDatesSequenceSequence;
		}
		
		@Override
		public CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder getOrCreateCommodityValuationDatesSequenceSequence() {
			CommodityValuationDatesSequenceSequence.CommodityValuationDatesSequenceSequenceBuilder result;
			if (commodityValuationDatesSequenceSequence!=null) {
				result = commodityValuationDatesSequenceSequence;
			}
			else {
				result = commodityValuationDatesSequenceSequence = CommodityValuationDatesSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriods")
		public List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods() {
			return settlementPeriods;
		}
		
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
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder setLag(Lag lag) {
			this.lag = lag==null?null:lag.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityValuationDatesSequenceSequence")
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder setCommodityValuationDatesSequenceSequence(CommodityValuationDatesSequenceSequence commodityValuationDatesSequenceSequence) {
			this.commodityValuationDatesSequenceSequence = commodityValuationDatesSequenceSequence==null?null:commodityValuationDatesSequenceSequence.toBuilder();
			return this;
		}
		@Override
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriods(SettlementPeriods settlementPeriods) {
			if (settlementPeriods!=null) this.settlementPeriods.add(settlementPeriods.toBuilder());
			return this;
		}
		
		@Override
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriods(SettlementPeriods settlementPeriods, int _idx) {
			getIndex(this.settlementPeriods, _idx, () -> settlementPeriods.toBuilder());
			return this;
		}
		@Override 
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss != null) {
				for (SettlementPeriods toAdd : settlementPeriodss) {
					this.settlementPeriods.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriods")
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
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
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference) {
			if (settlementPeriodsReference!=null) this.settlementPeriodsReference.add(settlementPeriodsReference.toBuilder());
			return this;
		}
		
		@Override
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriodsReference(SettlementPeriodsReference settlementPeriodsReference, int _idx) {
			getIndex(this.settlementPeriodsReference, _idx, () -> settlementPeriodsReference.toBuilder());
			return this;
		}
		@Override 
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder addSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
			if (settlementPeriodsReferences != null) {
				for (SettlementPeriodsReference toAdd : settlementPeriodsReferences) {
					this.settlementPeriodsReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("settlementPeriodsReference")
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder setSettlementPeriodsReference(List<? extends SettlementPeriodsReference> settlementPeriodsReferences) {
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
		public CommodityValuationDatesSequence build() {
			return new CommodityValuationDatesSequence.CommodityValuationDatesSequenceImpl(this);
		}
		
		@Override
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder prune() {
			if (lag!=null && !lag.prune().hasData()) lag = null;
			if (commodityValuationDatesSequenceSequence!=null && !commodityValuationDatesSequenceSequence.prune().hasData()) commodityValuationDatesSequenceSequence = null;
			settlementPeriods = settlementPeriods.stream().filter(b->b!=null).<SettlementPeriods.SettlementPeriodsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			settlementPeriodsReference = settlementPeriodsReference.stream().filter(b->b!=null).<SettlementPeriodsReference.SettlementPeriodsReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLag()!=null && getLag().hasData()) return true;
			if (getCommodityValuationDatesSequenceSequence()!=null && getCommodityValuationDatesSequenceSequence().hasData()) return true;
			if (getSettlementPeriods()!=null && getSettlementPeriods().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsReference()!=null && getSettlementPeriodsReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder o = (CommodityValuationDatesSequence.CommodityValuationDatesSequenceBuilder) other;
			
			merger.mergeRosetta(getLag(), o.getLag(), this::setLag);
			merger.mergeRosetta(getCommodityValuationDatesSequenceSequence(), o.getCommodityValuationDatesSequenceSequence(), this::setCommodityValuationDatesSequenceSequence);
			merger.mergeRosetta(getSettlementPeriods(), o.getSettlementPeriods(), this::getOrCreateSettlementPeriods);
			merger.mergeRosetta(getSettlementPeriodsReference(), o.getSettlementPeriodsReference(), this::getOrCreateSettlementPeriodsReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityValuationDatesSequence _that = getType().cast(o);
		
			if (!Objects.equals(lag, _that.getLag())) return false;
			if (!Objects.equals(commodityValuationDatesSequenceSequence, _that.getCommodityValuationDatesSequenceSequence())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriodsReference, _that.getSettlementPeriodsReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lag != null ? lag.hashCode() : 0);
			_result = 31 * _result + (commodityValuationDatesSequenceSequence != null ? commodityValuationDatesSequenceSequence.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsReference != null ? settlementPeriodsReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityValuationDatesSequenceBuilder {" +
				"lag=" + this.lag + ", " +
				"commodityValuationDatesSequenceSequence=" + this.commodityValuationDatesSequenceSequence + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsReference=" + this.settlementPeriodsReference +
			'}';
		}
	}
}
