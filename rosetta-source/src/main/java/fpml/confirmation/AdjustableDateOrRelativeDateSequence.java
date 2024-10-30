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
import fpml.confirmation.AdjustableDateOrRelativeDateSequence;
import fpml.confirmation.AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder;
import fpml.confirmation.AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilderImpl;
import fpml.confirmation.AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceImpl;
import fpml.confirmation.RelativeDateSequence;
import fpml.confirmation.meta.AdjustableDateOrRelativeDateSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing a date defined as subject to adjustment or defined in reference to another date through one or several date offsets.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AdjustableDateOrRelativeDateSequence", builder=AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AdjustableDateOrRelativeDateSequence extends RosettaModelObject {

	AdjustableDateOrRelativeDateSequenceMeta metaData = new AdjustableDateOrRelativeDateSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDate getAdjustableDate();
	/**
	 * A date specified in relation to some other date defined in the document (the anchor date), where there is the opportunity to specify a combination of offset rules. This component will typically be used for defining the valuation date in relation to the payment date, as both the currency and the exchange holiday calendars need to be considered.
	 */
	RelativeDateSequence getRelativeDateSequence();
	String getId();

	/*********************** Build Methods  ***********************/
	AdjustableDateOrRelativeDateSequence build();
	
	AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder toBuilder();
	
	static AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder builder() {
		return new AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDateOrRelativeDateSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableDateOrRelativeDateSequence> getType() {
		return AdjustableDateOrRelativeDateSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
		processRosetta(path.newSubPath("relativeDateSequence"), processor, RelativeDateSequence.class, getRelativeDateSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDateOrRelativeDateSequenceBuilder extends AdjustableDateOrRelativeDateSequence, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		RelativeDateSequence.RelativeDateSequenceBuilder getOrCreateRelativeDateSequence();
		RelativeDateSequence.RelativeDateSequenceBuilder getRelativeDateSequence();
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setAdjustableDate(AdjustableDate adjustableDate);
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setRelativeDateSequence(RelativeDateSequence relativeDateSequence);
		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
			processRosetta(path.newSubPath("relativeDateSequence"), processor, RelativeDateSequence.RelativeDateSequenceBuilder.class, getRelativeDateSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableDateOrRelativeDateSequence  ***********************/
	class AdjustableDateOrRelativeDateSequenceImpl implements AdjustableDateOrRelativeDateSequence {
		private final AdjustableDate adjustableDate;
		private final RelativeDateSequence relativeDateSequence;
		private final String id;
		
		protected AdjustableDateOrRelativeDateSequenceImpl(AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder builder) {
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
			this.relativeDateSequence = ofNullable(builder.getRelativeDateSequence()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustableDate")
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		@RosettaAttribute("relativeDateSequence")
		public RelativeDateSequence getRelativeDateSequence() {
			return relativeDateSequence;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence build() {
			return this;
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder toBuilder() {
			AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder builder) {
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
			ofNullable(getRelativeDateSequence()).ifPresent(builder::setRelativeDateSequence);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDateOrRelativeDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(relativeDateSequence, _that.getRelativeDateSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (relativeDateSequence != null ? relativeDateSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDateOrRelativeDateSequence {" +
				"adjustableDate=" + this.adjustableDate + ", " +
				"relativeDateSequence=" + this.relativeDateSequence + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDateOrRelativeDateSequence  ***********************/
	class AdjustableDateOrRelativeDateSequenceBuilderImpl implements AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder {
	
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
		protected RelativeDateSequence.RelativeDateSequenceBuilder relativeDateSequence;
		protected String id;
	
		public AdjustableDateOrRelativeDateSequenceBuilderImpl() {
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
		@RosettaAttribute("relativeDateSequence")
		public RelativeDateSequence.RelativeDateSequenceBuilder getRelativeDateSequence() {
			return relativeDateSequence;
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder getOrCreateRelativeDateSequence() {
			RelativeDateSequence.RelativeDateSequenceBuilder result;
			if (relativeDateSequence!=null) {
				result = relativeDateSequence;
			}
			else {
				result = relativeDateSequence = RelativeDateSequence.builder();
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
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setAdjustableDate(AdjustableDate adjustableDate) {
			this.adjustableDate = adjustableDate==null?null:adjustableDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDateSequence")
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setRelativeDateSequence(RelativeDateSequence relativeDateSequence) {
			this.relativeDateSequence = relativeDateSequence==null?null:relativeDateSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence build() {
			return new AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceImpl(this);
		}
		
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder prune() {
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			if (relativeDateSequence!=null && !relativeDateSequence.prune().hasData()) relativeDateSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			if (getRelativeDateSequence()!=null && getRelativeDateSequence().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder o = (AdjustableDateOrRelativeDateSequence.AdjustableDateOrRelativeDateSequenceBuilder) other;
			
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			merger.mergeRosetta(getRelativeDateSequence(), o.getRelativeDateSequence(), this::setRelativeDateSequence);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDateOrRelativeDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(relativeDateSequence, _that.getRelativeDateSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (relativeDateSequence != null ? relativeDateSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDateOrRelativeDateSequenceBuilder {" +
				"adjustableDate=" + this.adjustableDate + ", " +
				"relativeDateSequence=" + this.relativeDateSequence + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
