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
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder;
import fpml.confirmation.AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilderImpl;
import fpml.confirmation.AdjustableOrRelativeDate.AdjustableOrRelativeDateImpl;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.meta.AdjustableOrRelativeDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type giving the choice between defining a date as an explicit date together with applicable adjustments or as relative to some other (anchor) date.
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableOrRelativeDate", builder=AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilderImpl.class, version="${project.version}")
public interface AdjustableOrRelativeDate extends RosettaModelObject {

	AdjustableOrRelativeDateMeta metaData = new AdjustableOrRelativeDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDate getAdjustableDate();
	/**
	 * A date specified as some offset to another date (the anchor date).
	 */
	RelativeDateOffset getRelativeDate();
	String getId();

	/*********************** Build Methods  ***********************/
	AdjustableOrRelativeDate build();
	
	AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder();
	
	static AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder() {
		return new AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableOrRelativeDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableOrRelativeDate> getType() {
		return AdjustableOrRelativeDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
		processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.class, getRelativeDate());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableOrRelativeDateBuilder extends AdjustableOrRelativeDate, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateRelativeDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getRelativeDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setAdjustableDate(AdjustableDate adjustableDate);
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setRelativeDate(RelativeDateOffset relativeDate);
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
			processRosetta(path.newSubPath("relativeDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getRelativeDate());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableOrRelativeDate  ***********************/
	class AdjustableOrRelativeDateImpl implements AdjustableOrRelativeDate {
		private final AdjustableDate adjustableDate;
		private final RelativeDateOffset relativeDate;
		private final String id;
		
		protected AdjustableOrRelativeDateImpl(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder) {
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
			this.relativeDate = ofNullable(builder.getRelativeDate()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		@RosettaAttribute("relativeDate")
		public RelativeDateOffset getRelativeDate() {
			return relativeDate;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public AdjustableOrRelativeDate build() {
			return this;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder builder) {
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
			ofNullable(getRelativeDate()).ifPresent(builder::setRelativeDate);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrRelativeDate {" +
				"adjustableDate=" + this.adjustableDate + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableOrRelativeDate  ***********************/
	class AdjustableOrRelativeDateBuilderImpl implements AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder {
	
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder relativeDate;
		protected String id;
	
		public AdjustableOrRelativeDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableDate.AdjustableDateBuilder getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (adjustableDate!=null) {
				result = adjustableDate;
			}
			else {
				result = adjustableDate = AdjustableDate.builder();
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
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setAdjustableDate(AdjustableDate adjustableDate) {
			this.adjustableDate = adjustableDate==null?null:adjustableDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setRelativeDate(RelativeDateOffset relativeDate) {
			this.relativeDate = relativeDate==null?null:relativeDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AdjustableOrRelativeDate build() {
			return new AdjustableOrRelativeDate.AdjustableOrRelativeDateImpl(this);
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder prune() {
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			if (relativeDate!=null && !relativeDate.prune().hasData()) relativeDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			if (getRelativeDate()!=null && getRelativeDate().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder o = (AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder) other;
			
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			merger.mergeRosetta(getRelativeDate(), o.getRelativeDate(), this::setRelativeDate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableOrRelativeDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(relativeDate, _that.getRelativeDate())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (relativeDate != null ? relativeDate.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableOrRelativeDateBuilder {" +
				"adjustableDate=" + this.adjustableDate + ", " +
				"relativeDate=" + this.relativeDate + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
