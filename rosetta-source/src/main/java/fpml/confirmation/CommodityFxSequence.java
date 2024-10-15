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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CommodityFxSequence;
import fpml.confirmation.CommodityFxSequence.CommodityFxSequenceBuilder;
import fpml.confirmation.CommodityFxSequence.CommodityFxSequenceBuilderImpl;
import fpml.confirmation.CommodityFxSequence.CommodityFxSequenceImpl;
import fpml.confirmation.CommodityFxSequenceSequence;
import fpml.confirmation.meta.CommodityFxSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFxSequence", builder=CommodityFxSequence.CommodityFxSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityFxSequence extends RosettaModelObject {

	CommodityFxSequenceMeta metaData = new CommodityFxSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A list of the fx observation dates for a given Calculation Period.
	 */
	List<? extends AdjustableDates> getFxObservationDates();
	CommodityFxSequenceSequence getCommodityFxSequenceSequence();
	/**
	 * The time at which the spot currency exchange rate will be observed. It is specified as a time in a specific business center, e.g. 11:00am London time.
	 */
	BusinessCenterTime getFixingTime();

	/*********************** Build Methods  ***********************/
	CommodityFxSequence build();
	
	CommodityFxSequence.CommodityFxSequenceBuilder toBuilder();
	
	static CommodityFxSequence.CommodityFxSequenceBuilder builder() {
		return new CommodityFxSequence.CommodityFxSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFxSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFxSequence> getType() {
		return CommodityFxSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxObservationDates"), processor, AdjustableDates.class, getFxObservationDates());
		processRosetta(path.newSubPath("commodityFxSequenceSequence"), processor, CommodityFxSequenceSequence.class, getCommodityFxSequenceSequence());
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFxSequenceBuilder extends CommodityFxSequence, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateFxObservationDates(int _index);
		List<? extends AdjustableDates.AdjustableDatesBuilder> getFxObservationDates();
		CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder getOrCreateCommodityFxSequenceSequence();
		CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder getCommodityFxSequenceSequence();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		CommodityFxSequence.CommodityFxSequenceBuilder addFxObservationDates(AdjustableDates fxObservationDates0);
		CommodityFxSequence.CommodityFxSequenceBuilder addFxObservationDates(AdjustableDates fxObservationDates1, int _idx);
		CommodityFxSequence.CommodityFxSequenceBuilder addFxObservationDates(List<? extends AdjustableDates> fxObservationDates2);
		CommodityFxSequence.CommodityFxSequenceBuilder setFxObservationDates(List<? extends AdjustableDates> fxObservationDates3);
		CommodityFxSequence.CommodityFxSequenceBuilder setCommodityFxSequenceSequence(CommodityFxSequenceSequence commodityFxSequenceSequence);
		CommodityFxSequence.CommodityFxSequenceBuilder setFixingTime(BusinessCenterTime fixingTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxObservationDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getFxObservationDates());
			processRosetta(path.newSubPath("commodityFxSequenceSequence"), processor, CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder.class, getCommodityFxSequenceSequence());
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
		}
		

		CommodityFxSequence.CommodityFxSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFxSequence  ***********************/
	class CommodityFxSequenceImpl implements CommodityFxSequence {
		private final List<? extends AdjustableDates> fxObservationDates;
		private final CommodityFxSequenceSequence commodityFxSequenceSequence;
		private final BusinessCenterTime fixingTime;
		
		protected CommodityFxSequenceImpl(CommodityFxSequence.CommodityFxSequenceBuilder builder) {
			this.fxObservationDates = ofNullable(builder.getFxObservationDates()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commodityFxSequenceSequence = ofNullable(builder.getCommodityFxSequenceSequence()).map(f->f.build()).orElse(null);
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxObservationDates")
		public List<? extends AdjustableDates> getFxObservationDates() {
			return fxObservationDates;
		}
		
		@Override
		@RosettaAttribute("commodityFxSequenceSequence")
		public CommodityFxSequenceSequence getCommodityFxSequenceSequence() {
			return commodityFxSequenceSequence;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public CommodityFxSequence build() {
			return this;
		}
		
		@Override
		public CommodityFxSequence.CommodityFxSequenceBuilder toBuilder() {
			CommodityFxSequence.CommodityFxSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFxSequence.CommodityFxSequenceBuilder builder) {
			ofNullable(getFxObservationDates()).ifPresent(builder::setFxObservationDates);
			ofNullable(getCommodityFxSequenceSequence()).ifPresent(builder::setCommodityFxSequenceSequence);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fxObservationDates, _that.getFxObservationDates())) return false;
			if (!Objects.equals(commodityFxSequenceSequence, _that.getCommodityFxSequenceSequence())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxObservationDates != null ? fxObservationDates.hashCode() : 0);
			_result = 31 * _result + (commodityFxSequenceSequence != null ? commodityFxSequenceSequence.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxSequence {" +
				"fxObservationDates=" + this.fxObservationDates + ", " +
				"commodityFxSequenceSequence=" + this.commodityFxSequenceSequence + ", " +
				"fixingTime=" + this.fixingTime +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFxSequence  ***********************/
	class CommodityFxSequenceBuilderImpl implements CommodityFxSequence.CommodityFxSequenceBuilder {
	
		protected List<AdjustableDates.AdjustableDatesBuilder> fxObservationDates = new ArrayList<>();
		protected CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder commodityFxSequenceSequence;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
	
		public CommodityFxSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxObservationDates")
		public List<? extends AdjustableDates.AdjustableDatesBuilder> getFxObservationDates() {
			return fxObservationDates;
		}
		
		public AdjustableDates.AdjustableDatesBuilder getOrCreateFxObservationDates(int _index) {
		
			if (fxObservationDates==null) {
				this.fxObservationDates = new ArrayList<>();
			}
			AdjustableDates.AdjustableDatesBuilder result;
			return getIndex(fxObservationDates, _index, () -> {
						AdjustableDates.AdjustableDatesBuilder newFxObservationDates = AdjustableDates.builder();
						return newFxObservationDates;
					});
		}
		
		@Override
		@RosettaAttribute("commodityFxSequenceSequence")
		public CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder getCommodityFxSequenceSequence() {
			return commodityFxSequenceSequence;
		}
		
		@Override
		public CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder getOrCreateCommodityFxSequenceSequence() {
			CommodityFxSequenceSequence.CommodityFxSequenceSequenceBuilder result;
			if (commodityFxSequenceSequence!=null) {
				result = commodityFxSequenceSequence;
			}
			else {
				result = commodityFxSequenceSequence = CommodityFxSequenceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		public CommodityFxSequence.CommodityFxSequenceBuilder addFxObservationDates(AdjustableDates fxObservationDates) {
			if (fxObservationDates!=null) this.fxObservationDates.add(fxObservationDates.toBuilder());
			return this;
		}
		
		@Override
		public CommodityFxSequence.CommodityFxSequenceBuilder addFxObservationDates(AdjustableDates fxObservationDates, int _idx) {
			getIndex(this.fxObservationDates, _idx, () -> fxObservationDates.toBuilder());
			return this;
		}
		@Override 
		public CommodityFxSequence.CommodityFxSequenceBuilder addFxObservationDates(List<? extends AdjustableDates> fxObservationDatess) {
			if (fxObservationDatess != null) {
				for (AdjustableDates toAdd : fxObservationDatess) {
					this.fxObservationDates.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fxObservationDates")
		public CommodityFxSequence.CommodityFxSequenceBuilder setFxObservationDates(List<? extends AdjustableDates> fxObservationDatess) {
			if (fxObservationDatess == null)  {
				this.fxObservationDates = new ArrayList<>();
			}
			else {
				this.fxObservationDates = fxObservationDatess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("commodityFxSequenceSequence")
		public CommodityFxSequence.CommodityFxSequenceBuilder setCommodityFxSequenceSequence(CommodityFxSequenceSequence commodityFxSequenceSequence) {
			this.commodityFxSequenceSequence = commodityFxSequenceSequence==null?null:commodityFxSequenceSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingTime")
		public CommodityFxSequence.CommodityFxSequenceBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFxSequence build() {
			return new CommodityFxSequence.CommodityFxSequenceImpl(this);
		}
		
		@Override
		public CommodityFxSequence.CommodityFxSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxSequence.CommodityFxSequenceBuilder prune() {
			fxObservationDates = fxObservationDates.stream().filter(b->b!=null).<AdjustableDates.AdjustableDatesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commodityFxSequenceSequence!=null && !commodityFxSequenceSequence.prune().hasData()) commodityFxSequenceSequence = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxObservationDates()!=null && getFxObservationDates().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommodityFxSequenceSequence()!=null && getCommodityFxSequenceSequence().hasData()) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxSequence.CommodityFxSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFxSequence.CommodityFxSequenceBuilder o = (CommodityFxSequence.CommodityFxSequenceBuilder) other;
			
			merger.mergeRosetta(getFxObservationDates(), o.getFxObservationDates(), this::getOrCreateFxObservationDates);
			merger.mergeRosetta(getCommodityFxSequenceSequence(), o.getCommodityFxSequenceSequence(), this::setCommodityFxSequenceSequence);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fxObservationDates, _that.getFxObservationDates())) return false;
			if (!Objects.equals(commodityFxSequenceSequence, _that.getCommodityFxSequenceSequence())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxObservationDates != null ? fxObservationDates.hashCode() : 0);
			_result = 31 * _result + (commodityFxSequenceSequence != null ? commodityFxSequenceSequence.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxSequenceBuilder {" +
				"fxObservationDates=" + this.fxObservationDates + ", " +
				"commodityFxSequenceSequence=" + this.commodityFxSequenceSequence + ", " +
				"fixingTime=" + this.fixingTime +
			'}';
		}
	}
}
