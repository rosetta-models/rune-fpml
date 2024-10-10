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
import fpml.confirmation.QuantityReference;
import fpml.confirmation.QuantityReference.QuantityReferenceBuilder;
import fpml.confirmation.QuantityReference.QuantityReferenceBuilderImpl;
import fpml.confirmation.QuantityReference.QuantityReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.QuantityReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A pointer tyle reference to a Quantity defined elsewhere.
 * @version ${project.version}
 */
@RosettaDataType(value="QuantityReference", builder=QuantityReference.QuantityReferenceBuilderImpl.class, version="${project.version}")
public interface QuantityReference extends Reference {

	QuantityReferenceMeta metaData = new QuantityReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	QuantityReference build();
	
	QuantityReference.QuantityReferenceBuilder toBuilder();
	
	static QuantityReference.QuantityReferenceBuilder builder() {
		return new QuantityReference.QuantityReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuantityReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends QuantityReference> getType() {
		return QuantityReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuantityReferenceBuilder extends QuantityReference, Reference.ReferenceBuilder {
		QuantityReference.QuantityReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		QuantityReference.QuantityReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of QuantityReference  ***********************/
	class QuantityReferenceImpl extends Reference.ReferenceImpl implements QuantityReference {
		private final String href;
		
		protected QuantityReferenceImpl(QuantityReference.QuantityReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public QuantityReference build() {
			return this;
		}
		
		@Override
		public QuantityReference.QuantityReferenceBuilder toBuilder() {
			QuantityReference.QuantityReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuantityReference.QuantityReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			QuantityReference _that = getType().cast(o);
		
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
			return "QuantityReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of QuantityReference  ***********************/
	class QuantityReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements QuantityReference.QuantityReferenceBuilder {
	
		protected String href;
	
		public QuantityReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public QuantityReference.QuantityReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public QuantityReference build() {
			return new QuantityReference.QuantityReferenceImpl(this);
		}
		
		@Override
		public QuantityReference.QuantityReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuantityReference.QuantityReferenceBuilder prune() {
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
		public QuantityReference.QuantityReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			QuantityReference.QuantityReferenceBuilder o = (QuantityReference.QuantityReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			QuantityReference _that = getType().cast(o);
		
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
			return "QuantityReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
