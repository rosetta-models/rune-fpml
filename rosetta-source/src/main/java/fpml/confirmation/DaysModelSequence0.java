package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CommodityFrequencyType;
import fpml.confirmation.DaysModelSequence0;
import fpml.confirmation.DaysModelSequence0.DaysModelSequence0Builder;
import fpml.confirmation.DaysModelSequence0.DaysModelSequence0BuilderImpl;
import fpml.confirmation.DaysModelSequence0.DaysModelSequence0Impl;
import fpml.confirmation.meta.DaysModelSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DaysModelSequence0", builder=DaysModelSequence0.DaysModelSequence0BuilderImpl.class, version="${project.version}")
public interface DaysModelSequence0 extends RosettaModelObject {

	DaysModelSequence0Meta metaData = new DaysModelSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The method by which the pricing days are distributed across the pricing period.
	 */
	CommodityFrequencyType getDayDistribution();
	/**
	 * The number of days over which pricing should take place.
	 */
	Integer getDayCount();

	/*********************** Build Methods  ***********************/
	DaysModelSequence0 build();
	
	DaysModelSequence0.DaysModelSequence0Builder toBuilder();
	
	static DaysModelSequence0.DaysModelSequence0Builder builder() {
		return new DaysModelSequence0.DaysModelSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DaysModelSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DaysModelSequence0> getType() {
		return DaysModelSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dayDistribution"), processor, CommodityFrequencyType.class, getDayDistribution());
		processor.processBasic(path.newSubPath("dayCount"), Integer.class, getDayCount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DaysModelSequence0Builder extends DaysModelSequence0, RosettaModelObjectBuilder {
		CommodityFrequencyType.CommodityFrequencyTypeBuilder getOrCreateDayDistribution();
		CommodityFrequencyType.CommodityFrequencyTypeBuilder getDayDistribution();
		DaysModelSequence0.DaysModelSequence0Builder setDayDistribution(CommodityFrequencyType dayDistribution);
		DaysModelSequence0.DaysModelSequence0Builder setDayCount(Integer dayCount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dayDistribution"), processor, CommodityFrequencyType.CommodityFrequencyTypeBuilder.class, getDayDistribution());
			processor.processBasic(path.newSubPath("dayCount"), Integer.class, getDayCount(), this);
		}
		

		DaysModelSequence0.DaysModelSequence0Builder prune();
	}

	/*********************** Immutable Implementation of DaysModelSequence0  ***********************/
	class DaysModelSequence0Impl implements DaysModelSequence0 {
		private final CommodityFrequencyType dayDistribution;
		private final Integer dayCount;
		
		protected DaysModelSequence0Impl(DaysModelSequence0.DaysModelSequence0Builder builder) {
			this.dayDistribution = ofNullable(builder.getDayDistribution()).map(f->f.build()).orElse(null);
			this.dayCount = builder.getDayCount();
		}
		
		@Override
		@RosettaAttribute("dayDistribution")
		public CommodityFrequencyType getDayDistribution() {
			return dayDistribution;
		}
		
		@Override
		@RosettaAttribute("dayCount")
		public Integer getDayCount() {
			return dayCount;
		}
		
		@Override
		public DaysModelSequence0 build() {
			return this;
		}
		
		@Override
		public DaysModelSequence0.DaysModelSequence0Builder toBuilder() {
			DaysModelSequence0.DaysModelSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DaysModelSequence0.DaysModelSequence0Builder builder) {
			ofNullable(getDayDistribution()).ifPresent(builder::setDayDistribution);
			ofNullable(getDayCount()).ifPresent(builder::setDayCount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DaysModelSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(dayDistribution, _that.getDayDistribution())) return false;
			if (!Objects.equals(dayCount, _that.getDayCount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayDistribution != null ? dayDistribution.hashCode() : 0);
			_result = 31 * _result + (dayCount != null ? dayCount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DaysModelSequence0 {" +
				"dayDistribution=" + this.dayDistribution + ", " +
				"dayCount=" + this.dayCount +
			'}';
		}
	}

	/*********************** Builder Implementation of DaysModelSequence0  ***********************/
	class DaysModelSequence0BuilderImpl implements DaysModelSequence0.DaysModelSequence0Builder {
	
		protected CommodityFrequencyType.CommodityFrequencyTypeBuilder dayDistribution;
		protected Integer dayCount;
	
		public DaysModelSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dayDistribution")
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder getDayDistribution() {
			return dayDistribution;
		}
		
		@Override
		public CommodityFrequencyType.CommodityFrequencyTypeBuilder getOrCreateDayDistribution() {
			CommodityFrequencyType.CommodityFrequencyTypeBuilder result;
			if (dayDistribution!=null) {
				result = dayDistribution;
			}
			else {
				result = dayDistribution = CommodityFrequencyType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCount")
		public Integer getDayCount() {
			return dayCount;
		}
		
		@Override
		@RosettaAttribute("dayDistribution")
		public DaysModelSequence0.DaysModelSequence0Builder setDayDistribution(CommodityFrequencyType dayDistribution) {
			this.dayDistribution = dayDistribution==null?null:dayDistribution.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dayCount")
		public DaysModelSequence0.DaysModelSequence0Builder setDayCount(Integer dayCount) {
			this.dayCount = dayCount==null?null:dayCount;
			return this;
		}
		
		@Override
		public DaysModelSequence0 build() {
			return new DaysModelSequence0.DaysModelSequence0Impl(this);
		}
		
		@Override
		public DaysModelSequence0.DaysModelSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DaysModelSequence0.DaysModelSequence0Builder prune() {
			if (dayDistribution!=null && !dayDistribution.prune().hasData()) dayDistribution = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDayDistribution()!=null && getDayDistribution().hasData()) return true;
			if (getDayCount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DaysModelSequence0.DaysModelSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DaysModelSequence0.DaysModelSequence0Builder o = (DaysModelSequence0.DaysModelSequence0Builder) other;
			
			merger.mergeRosetta(getDayDistribution(), o.getDayDistribution(), this::setDayDistribution);
			
			merger.mergeBasic(getDayCount(), o.getDayCount(), this::setDayCount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DaysModelSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(dayDistribution, _that.getDayDistribution())) return false;
			if (!Objects.equals(dayCount, _that.getDayCount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dayDistribution != null ? dayDistribution.hashCode() : 0);
			_result = 31 * _result + (dayCount != null ? dayCount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DaysModelSequence0Builder {" +
				"dayDistribution=" + this.dayDistribution + ", " +
				"dayCount=" + this.dayCount +
			'}';
		}
	}
}
