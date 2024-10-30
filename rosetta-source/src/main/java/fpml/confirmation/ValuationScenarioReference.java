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
import fpml.confirmation.ValuationScenarioReference;
import fpml.confirmation.ValuationScenarioReference.ValuationScenarioReferenceBuilder;
import fpml.confirmation.ValuationScenarioReference.ValuationScenarioReferenceBuilderImpl;
import fpml.confirmation.ValuationScenarioReference.ValuationScenarioReferenceImpl;
import fpml.confirmation.meta.ValuationScenarioReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a valuation scenario.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ValuationScenarioReference", builder=ValuationScenarioReference.ValuationScenarioReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ValuationScenarioReference extends Reference {

	ValuationScenarioReferenceMeta metaData = new ValuationScenarioReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	ValuationScenarioReference build();
	
	ValuationScenarioReference.ValuationScenarioReferenceBuilder toBuilder();
	
	static ValuationScenarioReference.ValuationScenarioReferenceBuilder builder() {
		return new ValuationScenarioReference.ValuationScenarioReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationScenarioReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationScenarioReference> getType() {
		return ValuationScenarioReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationScenarioReferenceBuilder extends ValuationScenarioReference, Reference.ReferenceBuilder {
		ValuationScenarioReference.ValuationScenarioReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		ValuationScenarioReference.ValuationScenarioReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationScenarioReference  ***********************/
	class ValuationScenarioReferenceImpl extends Reference.ReferenceImpl implements ValuationScenarioReference {
		private final String href;
		
		protected ValuationScenarioReferenceImpl(ValuationScenarioReference.ValuationScenarioReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public ValuationScenarioReference build() {
			return this;
		}
		
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder toBuilder() {
			ValuationScenarioReference.ValuationScenarioReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationScenarioReference.ValuationScenarioReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationScenarioReference _that = getType().cast(o);
		
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
			return "ValuationScenarioReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationScenarioReference  ***********************/
	class ValuationScenarioReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements ValuationScenarioReference.ValuationScenarioReferenceBuilder {
	
		protected String href;
	
		public ValuationScenarioReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public ValuationScenarioReference build() {
			return new ValuationScenarioReference.ValuationScenarioReferenceImpl(this);
		}
		
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder prune() {
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
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ValuationScenarioReference.ValuationScenarioReferenceBuilder o = (ValuationScenarioReference.ValuationScenarioReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationScenarioReference _that = getType().cast(o);
		
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
			return "ValuationScenarioReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
