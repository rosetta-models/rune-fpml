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
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.CalculationPeriodsReference.CalculationPeriodsReferenceBuilder;
import fpml.confirmation.CalculationPeriodsReference.CalculationPeriodsReferenceBuilderImpl;
import fpml.confirmation.CalculationPeriodsReference.CalculationPeriodsReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.CalculationPeriodsReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A pointer style reference to a calculation periods schedule defined elsewhere - note that this schedule consists of a series of actual dates in a calculationPeriods container.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CalculationPeriodsReference", builder=CalculationPeriodsReference.CalculationPeriodsReferenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CalculationPeriodsReference extends Reference {

	CalculationPeriodsReferenceMeta metaData = new CalculationPeriodsReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	CalculationPeriodsReference build();
	
	CalculationPeriodsReference.CalculationPeriodsReferenceBuilder toBuilder();
	
	static CalculationPeriodsReference.CalculationPeriodsReferenceBuilder builder() {
		return new CalculationPeriodsReference.CalculationPeriodsReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodsReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationPeriodsReference> getType() {
		return CalculationPeriodsReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodsReferenceBuilder extends CalculationPeriodsReference, Reference.ReferenceBuilder {
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodsReference  ***********************/
	class CalculationPeriodsReferenceImpl extends Reference.ReferenceImpl implements CalculationPeriodsReference {
		private final String href;
		
		protected CalculationPeriodsReferenceImpl(CalculationPeriodsReference.CalculationPeriodsReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public CalculationPeriodsReference build() {
			return this;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder toBuilder() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodsReference.CalculationPeriodsReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodsReference _that = getType().cast(o);
		
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
			return "CalculationPeriodsReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationPeriodsReference  ***********************/
	class CalculationPeriodsReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements CalculationPeriodsReference.CalculationPeriodsReferenceBuilder {
	
		protected String href;
	
		public CalculationPeriodsReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public CalculationPeriodsReference build() {
			return new CalculationPeriodsReference.CalculationPeriodsReferenceImpl(this);
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder prune() {
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
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder o = (CalculationPeriodsReference.CalculationPeriodsReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodsReference _that = getType().cast(o);
		
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
			return "CalculationPeriodsReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
