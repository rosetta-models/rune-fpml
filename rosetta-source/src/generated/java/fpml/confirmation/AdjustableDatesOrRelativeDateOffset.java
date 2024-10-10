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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset;
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder;
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilderImpl;
import fpml.confirmation.AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetImpl;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.meta.AdjustableDatesOrRelativeDateOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining a series of dates, either as a list of adjustable dates, or a as a repeating sequence from a base date
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableDatesOrRelativeDateOffset", builder=AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilderImpl.class, version="${project.version}")
public interface AdjustableDatesOrRelativeDateOffset extends RosettaModelObject {

	AdjustableDatesOrRelativeDateOffsetMeta metaData = new AdjustableDatesOrRelativeDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A series of adjustable dates
	 */
	AdjustableDates getAdjustableDates();
	/**
	 * A series of dates specified as a repeating sequence from a base date.
	 */
	RelativeDateOffset getRelativeDate();

	/*********************** Build Methods  ***********************/
	AdjustableDatesOrRelativeDateOffset build();
	
	AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder toBuilder();
	
	static AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder builder() {
		return new AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDatesOrRelativeDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableDatesOrRelativeDateOffset> getType() {
		return AdjustableDatesOrRelativeDateOffset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDatesOrRelativeDateOffsetBuilder extends AdjustableDatesOrRelativeDateOffset, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder setAdjustableDates(AdjustableDates adjustableDates);
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder setRelativeDate(RelativeDateOffset relativeDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
		}
		

		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableDatesOrRelativeDateOffset  ***********************/
	class AdjustableDatesOrRelativeDateOffsetImpl implements AdjustableDatesOrRelativeDateOffset {
		private final AdjustableDates adjustableDates;
		private final RelativeDateOffset relativeDate;
		
		protected AdjustableDatesOrRelativeDateOffsetImpl(AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder builder) {
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableDates getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset build() {
			return this;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder toBuilder() {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder builder) {
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDatesOrRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDatesOrRelativeDateOffset {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDatesOrRelativeDateOffset  ***********************/
	class AdjustableDatesOrRelativeDateOffsetBuilderImpl implements AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
	
		public AdjustableDatesOrRelativeDateOffsetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableDates.AdjustableDatesBuilder getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (adjustableDates!=null) {
				result = adjustableDates;
			}
			else {
				result = adjustableDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (relativeDate!=null) {
				result = relativeDate;
			}
			else {
				result = relativeDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder setAdjustableDates(AdjustableDates adjustableDates) {
			this.adjustableDates = adjustableDates==null?null:adjustableDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDate")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder setRelativeDate(RelativeDateOffset relativeDate) {
			this.relativeDate = relativeDate==null?null:relativeDate.toBuilder();
			return this;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset build() {
			return new AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetImpl(this);
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder o = (AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDatesOrRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDatesOrRelativeDateOffsetBuilder {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDate=" + this.relativeDate +
			'}';
		}
	}
}
