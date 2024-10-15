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
import fpml.confirmation.NumberOfOptionsReference;
import fpml.confirmation.NumberOfOptionsReference.NumberOfOptionsReferenceBuilder;
import fpml.confirmation.NumberOfOptionsReference.NumberOfOptionsReferenceBuilderImpl;
import fpml.confirmation.NumberOfOptionsReference.NumberOfOptionsReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.NumberOfOptionsReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to the number of options.
 * @version ${project.version}
 */
@RosettaDataType(value="NumberOfOptionsReference", builder=NumberOfOptionsReference.NumberOfOptionsReferenceBuilderImpl.class, version="${project.version}")
public interface NumberOfOptionsReference extends Reference {

	NumberOfOptionsReferenceMeta metaData = new NumberOfOptionsReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	NumberOfOptionsReference build();
	
	NumberOfOptionsReference.NumberOfOptionsReferenceBuilder toBuilder();
	
	static NumberOfOptionsReference.NumberOfOptionsReferenceBuilder builder() {
		return new NumberOfOptionsReference.NumberOfOptionsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NumberOfOptionsReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NumberOfOptionsReference> getType() {
		return NumberOfOptionsReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NumberOfOptionsReferenceBuilder extends NumberOfOptionsReference, Reference.ReferenceBuilder {
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of NumberOfOptionsReference  ***********************/
	class NumberOfOptionsReferenceImpl extends Reference.ReferenceImpl implements NumberOfOptionsReference {
		private final String href;
		
		protected NumberOfOptionsReferenceImpl(NumberOfOptionsReference.NumberOfOptionsReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public NumberOfOptionsReference build() {
			return this;
		}
		
		@Override
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder toBuilder() {
			NumberOfOptionsReference.NumberOfOptionsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NumberOfOptionsReference.NumberOfOptionsReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NumberOfOptionsReference _that = getType().cast(o);
		
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
			return "NumberOfOptionsReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NumberOfOptionsReference  ***********************/
	class NumberOfOptionsReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements NumberOfOptionsReference.NumberOfOptionsReferenceBuilder {
	
		protected String href;
	
		public NumberOfOptionsReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public NumberOfOptionsReference build() {
			return new NumberOfOptionsReference.NumberOfOptionsReferenceImpl(this);
		}
		
		@Override
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder prune() {
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
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NumberOfOptionsReference.NumberOfOptionsReferenceBuilder o = (NumberOfOptionsReference.NumberOfOptionsReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NumberOfOptionsReference _that = getType().cast(o);
		
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
			return "NumberOfOptionsReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
