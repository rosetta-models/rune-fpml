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
import fpml.confirmation.ValuationDatesReference;
import fpml.confirmation.ValuationDatesReference.ValuationDatesReferenceBuilder;
import fpml.confirmation.ValuationDatesReference.ValuationDatesReferenceBuilderImpl;
import fpml.confirmation.ValuationDatesReference.ValuationDatesReferenceImpl;
import fpml.confirmation.meta.ValuationDatesReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Reference to a Valuation dates node.
 * @version ${project.version}
 */
@RosettaDataType(value="ValuationDatesReference", builder=ValuationDatesReference.ValuationDatesReferenceBuilderImpl.class, version="${project.version}")
public interface ValuationDatesReference extends Reference {

	ValuationDatesReferenceMeta metaData = new ValuationDatesReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	ValuationDatesReference build();
	
	ValuationDatesReference.ValuationDatesReferenceBuilder toBuilder();
	
	static ValuationDatesReference.ValuationDatesReferenceBuilder builder() {
		return new ValuationDatesReference.ValuationDatesReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationDatesReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationDatesReference> getType() {
		return ValuationDatesReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationDatesReferenceBuilder extends ValuationDatesReference, Reference.ReferenceBuilder {
		ValuationDatesReference.ValuationDatesReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		ValuationDatesReference.ValuationDatesReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationDatesReference  ***********************/
	class ValuationDatesReferenceImpl extends Reference.ReferenceImpl implements ValuationDatesReference {
		private final String href;
		
		protected ValuationDatesReferenceImpl(ValuationDatesReference.ValuationDatesReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public ValuationDatesReference build() {
			return this;
		}
		
		@Override
		public ValuationDatesReference.ValuationDatesReferenceBuilder toBuilder() {
			ValuationDatesReference.ValuationDatesReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationDatesReference.ValuationDatesReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationDatesReference _that = getType().cast(o);
		
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
			return "ValuationDatesReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationDatesReference  ***********************/
	class ValuationDatesReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements ValuationDatesReference.ValuationDatesReferenceBuilder {
	
		protected String href;
	
		public ValuationDatesReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public ValuationDatesReference.ValuationDatesReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public ValuationDatesReference build() {
			return new ValuationDatesReference.ValuationDatesReferenceImpl(this);
		}
		
		@Override
		public ValuationDatesReference.ValuationDatesReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDatesReference.ValuationDatesReferenceBuilder prune() {
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
		public ValuationDatesReference.ValuationDatesReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ValuationDatesReference.ValuationDatesReferenceBuilder o = (ValuationDatesReference.ValuationDatesReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationDatesReference _that = getType().cast(o);
		
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
			return "ValuationDatesReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
