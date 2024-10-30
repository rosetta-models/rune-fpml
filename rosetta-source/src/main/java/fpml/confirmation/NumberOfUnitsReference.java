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
import fpml.confirmation.NumberOfUnitsReference;
import fpml.confirmation.NumberOfUnitsReference.NumberOfUnitsReferenceBuilder;
import fpml.confirmation.NumberOfUnitsReference.NumberOfUnitsReferenceBuilderImpl;
import fpml.confirmation.NumberOfUnitsReference.NumberOfUnitsReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.NumberOfUnitsReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A reference to the number of units.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NumberOfUnitsReference", builder=NumberOfUnitsReference.NumberOfUnitsReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NumberOfUnitsReference extends Reference {

	NumberOfUnitsReferenceMeta metaData = new NumberOfUnitsReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	NumberOfUnitsReference build();
	
	NumberOfUnitsReference.NumberOfUnitsReferenceBuilder toBuilder();
	
	static NumberOfUnitsReference.NumberOfUnitsReferenceBuilder builder() {
		return new NumberOfUnitsReference.NumberOfUnitsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NumberOfUnitsReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NumberOfUnitsReference> getType() {
		return NumberOfUnitsReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NumberOfUnitsReferenceBuilder extends NumberOfUnitsReference, Reference.ReferenceBuilder {
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of NumberOfUnitsReference  ***********************/
	class NumberOfUnitsReferenceImpl extends Reference.ReferenceImpl implements NumberOfUnitsReference {
		private final String href;
		
		protected NumberOfUnitsReferenceImpl(NumberOfUnitsReference.NumberOfUnitsReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public NumberOfUnitsReference build() {
			return this;
		}
		
		@Override
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder toBuilder() {
			NumberOfUnitsReference.NumberOfUnitsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NumberOfUnitsReference.NumberOfUnitsReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NumberOfUnitsReference _that = getType().cast(o);
		
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
			return "NumberOfUnitsReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NumberOfUnitsReference  ***********************/
	class NumberOfUnitsReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements NumberOfUnitsReference.NumberOfUnitsReferenceBuilder {
	
		protected String href;
	
		public NumberOfUnitsReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public NumberOfUnitsReference build() {
			return new NumberOfUnitsReference.NumberOfUnitsReferenceImpl(this);
		}
		
		@Override
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder prune() {
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
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NumberOfUnitsReference.NumberOfUnitsReferenceBuilder o = (NumberOfUnitsReference.NumberOfUnitsReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NumberOfUnitsReference _that = getType().cast(o);
		
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
			return "NumberOfUnitsReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
