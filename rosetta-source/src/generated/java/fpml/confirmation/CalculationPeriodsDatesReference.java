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
import fpml.confirmation.CalculationPeriodsDatesReference;
import fpml.confirmation.CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder;
import fpml.confirmation.CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilderImpl;
import fpml.confirmation.CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceImpl;
import fpml.confirmation.Reference;
import fpml.confirmation.Reference.ReferenceBuilder;
import fpml.confirmation.Reference.ReferenceBuilderImpl;
import fpml.confirmation.Reference.ReferenceImpl;
import fpml.confirmation.meta.CalculationPeriodsDatesReferenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A pointer style reference to single-day-duration calculation periods defined elsewhere - note that this schedule consists of a parameterised schedule in a calculationPeriodsSchedule container.
 * @version ${project.version}
 */
@RosettaDataType(value="CalculationPeriodsDatesReference", builder=CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilderImpl.class, version="${project.version}")
public interface CalculationPeriodsDatesReference extends Reference {

	CalculationPeriodsDatesReferenceMeta metaData = new CalculationPeriodsDatesReferenceMeta();

	/*********************** Getter Methods  ***********************/
	String getHref();

	/*********************** Build Methods  ***********************/
	CalculationPeriodsDatesReference build();
	
	CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder toBuilder();
	
	static CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder builder() {
		return new CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationPeriodsDatesReference> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationPeriodsDatesReference> getType() {
		return CalculationPeriodsDatesReference.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationPeriodsDatesReferenceBuilder extends CalculationPeriodsDatesReference, Reference.ReferenceBuilder {
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder setHref(String href);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("href"), String.class, getHref(), this);
		}
		

		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationPeriodsDatesReference  ***********************/
	class CalculationPeriodsDatesReferenceImpl extends Reference.ReferenceImpl implements CalculationPeriodsDatesReference {
		private final String href;
		
		protected CalculationPeriodsDatesReferenceImpl(CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder builder) {
			super(builder);
			this.href = builder.getHref();
		}
		
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		public CalculationPeriodsDatesReference build() {
			return this;
		}
		
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder toBuilder() {
			CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHref()).ifPresent(builder::setHref);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodsDatesReference _that = getType().cast(o);
		
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
			return "CalculationPeriodsDatesReference {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CalculationPeriodsDatesReference  ***********************/
	class CalculationPeriodsDatesReferenceBuilderImpl extends Reference.ReferenceBuilderImpl  implements CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder {
	
		protected String href;
	
		public CalculationPeriodsDatesReferenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("href")
		public String getHref() {
			return href;
		}
		
		@Override
		@RosettaAttribute("href")
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder setHref(String href) {
			this.href = href==null?null:href;
			return this;
		}
		
		@Override
		public CalculationPeriodsDatesReference build() {
			return new CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceImpl(this);
		}
		
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder prune() {
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
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder o = (CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder) other;
			
			
			merger.mergeBasic(getHref(), o.getHref(), this::setHref);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CalculationPeriodsDatesReference _that = getType().cast(o);
		
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
			return "CalculationPeriodsDatesReferenceBuilder {" +
				"href=" + this.href +
			'}' + " " + super.toString();
		}
	}
}
