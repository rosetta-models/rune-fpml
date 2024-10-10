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
import fpml.confirmation.IdentifiedCurrencyReference;
import fpml.confirmation.IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder;
import fpml.confirmation.IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilderImpl;
import fpml.confirmation.IdentifiedCurrencyReference.IdentifiedCurrencyReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.IdentifiedCurrencyReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a currency with ID attribute
 * @version ${project.version}
 */
@RosettaDataType(value="IdentifiedCurrencyReference", builder=IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilderImpl.class, version="${project.version}")
public interface IdentifiedCurrencyReference extends Reference {

	IdentifiedCurrencyReferenceMeta metaData = new IdentifiedCurrencyReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	IdentifiedCurrencyReference build();
	
	IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder toBuilder();
	
	static IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder builder() {
		return new IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IdentifiedCurrencyReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IdentifiedCurrencyReference> getType() {
		return IdentifiedCurrencyReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IdentifiedCurrencyReferenceBuilder extends IdentifiedCurrencyReference, Reference.ReferenceBuilder {
		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of IdentifiedCurrencyReference  ***********************/
	class IdentifiedCurrencyReferenceImpl extends Reference.ReferenceImpl implements IdentifiedCurrencyReference {
		private final String href;
		
		protected IdentifiedCurrencyReferenceImpl(IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public IdentifiedCurrencyReference build() {
			return this;
		}
		
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder toBuilder() {
			IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedCurrencyReference _that = getType().cast(o);
		
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
			return "IdentifiedCurrencyReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IdentifiedCurrencyReference  ***********************/
	class IdentifiedCurrencyReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder {
	
		protected String href;
	
		public IdentifiedCurrencyReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public IdentifiedCurrencyReference build() {
			return new IdentifiedCurrencyReference.IdentifiedCurrencyReferenceImpl(this);
		}
		
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder prune() {
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
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder o = (IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IdentifiedCurrencyReference _that = getType().cast(o);
		
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
			return "IdentifiedCurrencyReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
