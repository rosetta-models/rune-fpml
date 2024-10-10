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
import fpml.confirmation.ScheduleReference;
import fpml.confirmation.ScheduleReference.ScheduleReferenceBuilder;
import fpml.confirmation.ScheduleReference.ScheduleReferenceBuilderImpl;
import fpml.confirmation.ScheduleReference.ScheduleReferenceImpl;
import fpml.confirmation.meta.ScheduleReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a schedule of rates or amounts.
 * @version ${project.version}
 */
@RosettaDataType(value="ScheduleReference", builder=ScheduleReference.ScheduleReferenceBuilderImpl.class, version="${project.version}")
public interface ScheduleReference extends Reference {

	ScheduleReferenceMeta metaData = new ScheduleReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	ScheduleReference build();
	
	ScheduleReference.ScheduleReferenceBuilder toBuilder();
	
	static ScheduleReference.ScheduleReferenceBuilder builder() {
		return new ScheduleReference.ScheduleReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ScheduleReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ScheduleReference> getType() {
		return ScheduleReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ScheduleReferenceBuilder extends ScheduleReference, Reference.ReferenceBuilder {
		ScheduleReference.ScheduleReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		ScheduleReference.ScheduleReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of ScheduleReference  ***********************/
	class ScheduleReferenceImpl extends Reference.ReferenceImpl implements ScheduleReference {
		private final String href;
		
		protected ScheduleReferenceImpl(ScheduleReference.ScheduleReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public ScheduleReference build() {
			return this;
		}
		
		@Override
		public ScheduleReference.ScheduleReferenceBuilder toBuilder() {
			ScheduleReference.ScheduleReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ScheduleReference.ScheduleReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ScheduleReference _that = getType().cast(o);
		
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
			return "ScheduleReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ScheduleReference  ***********************/
	class ScheduleReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements ScheduleReference.ScheduleReferenceBuilder {
	
		protected String href;
	
		public ScheduleReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public ScheduleReference.ScheduleReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public ScheduleReference build() {
			return new ScheduleReference.ScheduleReferenceImpl(this);
		}
		
		@Override
		public ScheduleReference.ScheduleReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ScheduleReference.ScheduleReferenceBuilder prune() {
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
		public ScheduleReference.ScheduleReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ScheduleReference.ScheduleReferenceBuilder o = (ScheduleReference.ScheduleReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ScheduleReference _that = getType().cast(o);
		
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
			return "ScheduleReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
