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
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.SpreadScheduleReference;
import fpml.confirmation.SpreadScheduleReference.SpreadScheduleReferenceBuilder;
import fpml.confirmation.SpreadScheduleReference.SpreadScheduleReferenceBuilderImpl;
import fpml.confirmation.SpreadScheduleReference.SpreadScheduleReferenceImpl;
import fpml.confirmation.meta.SpreadScheduleReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides a reference to a spread schedule.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="SpreadScheduleReference", builder=SpreadScheduleReference.SpreadScheduleReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface SpreadScheduleReference extends Reference {

	SpreadScheduleReferenceMeta metaData = new SpreadScheduleReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	SpreadScheduleReference build();
	
	SpreadScheduleReference.SpreadScheduleReferenceBuilder toBuilder();
	
	static SpreadScheduleReference.SpreadScheduleReferenceBuilder builder() {
		return new SpreadScheduleReference.SpreadScheduleReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpreadScheduleReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SpreadScheduleReference> getType() {
		return SpreadScheduleReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpreadScheduleReferenceBuilder extends SpreadScheduleReference, Reference.ReferenceBuilder {
		SpreadScheduleReference.SpreadScheduleReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		SpreadScheduleReference.SpreadScheduleReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of SpreadScheduleReference  ***********************/
	class SpreadScheduleReferenceImpl extends Reference.ReferenceImpl implements SpreadScheduleReference {
		private final String href;
		
		protected SpreadScheduleReferenceImpl(SpreadScheduleReference.SpreadScheduleReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public SpreadScheduleReference build() {
			return this;
		}
		
		@Override
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder toBuilder() {
			SpreadScheduleReference.SpreadScheduleReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpreadScheduleReference.SpreadScheduleReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadScheduleReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SpreadScheduleReference  ***********************/
	class SpreadScheduleReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements SpreadScheduleReference.SpreadScheduleReferenceBuilder {
	
		protected String href;
	
		public SpreadScheduleReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public SpreadScheduleReference build() {
			return new SpreadScheduleReference.SpreadScheduleReferenceImpl(this);
		}
		
		@Override
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHref()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpreadScheduleReference.SpreadScheduleReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SpreadScheduleReference.SpreadScheduleReferenceBuilder o = (SpreadScheduleReference.SpreadScheduleReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SpreadScheduleReference _that = getType().cast(o);
		
			if (!Objects.equals(href, _that.getHref())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (href != null ? href.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpreadScheduleReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
