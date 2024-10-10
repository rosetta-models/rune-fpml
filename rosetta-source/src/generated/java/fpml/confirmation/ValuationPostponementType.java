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
import fpml.confirmation.ValuationPostponementType;
import fpml.confirmation.ValuationPostponementType.ValuationPostponementTypeBuilder;
import fpml.confirmation.ValuationPostponementType.ValuationPostponementTypeBuilderImpl;
import fpml.confirmation.ValuationPostponementType.ValuationPostponementTypeImpl;
import fpml.confirmation.meta.ValuationPostponementTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
 * @version ${project.version}
 */
@RosettaDataType(value="ValuationPostponementType", builder=ValuationPostponementType.ValuationPostponementTypeBuilderImpl.class, version="${project.version}")
public interface ValuationPostponementType extends RosettaModelObject {

	ValuationPostponementTypeMeta metaData = new ValuationPostponementTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The maximum number of days to wait for a quote from the disrupted settlement rate option before proceding to the next method.
	 */
	Integer getMaximumDaysOfPostponement();

	/*********************** Build Methods  ***********************/
	ValuationPostponementType build();
	
	ValuationPostponementType.ValuationPostponementTypeBuilder toBuilder();
	
	static ValuationPostponementType.ValuationPostponementTypeBuilder builder() {
		return new ValuationPostponementType.ValuationPostponementTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationPostponementType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ValuationPostponementType> getType() {
		return ValuationPostponementType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("maximumDaysOfPostponement"), Integer.class, getMaximumDaysOfPostponement(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationPostponementTypeBuilder extends ValuationPostponementType, RosettaModelObjectBuilder {
		ValuationPostponementType.ValuationPostponementTypeBuilder setMaximumDaysOfPostponement(Integer maximumDaysOfPostponement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("maximumDaysOfPostponement"), Integer.class, getMaximumDaysOfPostponement(), this);
		}
		

		ValuationPostponementType.ValuationPostponementTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationPostponementType  ***********************/
	class ValuationPostponementTypeImpl implements ValuationPostponementType {
		private final Integer maximumDaysOfPostponement;
		
		protected ValuationPostponementTypeImpl(ValuationPostponementType.ValuationPostponementTypeBuilder builder) {
			this.maximumDaysOfPostponement = builder.getMaximumDaysOfPostponement();
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfPostponement")
		public Integer getMaximumDaysOfPostponement() {
			return maximumDaysOfPostponement;
		}
		
		@Override
		public ValuationPostponementType build() {
			return this;
		}
		
		@Override
		public ValuationPostponementType.ValuationPostponementTypeBuilder toBuilder() {
			ValuationPostponementType.ValuationPostponementTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationPostponementType.ValuationPostponementTypeBuilder builder) {
			ofNullable(getMaximumDaysOfPostponement()).ifPresent(builder::setMaximumDaysOfPostponement);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationPostponementType _that = getType().cast(o);
		
			if (!Objects.equals(maximumDaysOfPostponement, _that.getMaximumDaysOfPostponement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (maximumDaysOfPostponement != null ? maximumDaysOfPostponement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationPostponementType {" +
				"maximumDaysOfPostponement=" + this.maximumDaysOfPostponement +
			'}';
		}
	}

	/*********************** Builder Implementation of ValuationPostponementType  ***********************/
	class ValuationPostponementTypeBuilderImpl implements ValuationPostponementType.ValuationPostponementTypeBuilder {
	
		protected Integer maximumDaysOfPostponement;
	
		public ValuationPostponementTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("maximumDaysOfPostponement")
		public Integer getMaximumDaysOfPostponement() {
			return maximumDaysOfPostponement;
		}
		
		@Override
		@RosettaAttribute("maximumDaysOfPostponement")
		public ValuationPostponementType.ValuationPostponementTypeBuilder setMaximumDaysOfPostponement(Integer maximumDaysOfPostponement) {
			this.maximumDaysOfPostponement = maximumDaysOfPostponement==null?null:maximumDaysOfPostponement;
			return this;
		}
		
		@Override
		public ValuationPostponementType build() {
			return new ValuationPostponementType.ValuationPostponementTypeImpl(this);
		}
		
		@Override
		public ValuationPostponementType.ValuationPostponementTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationPostponementType.ValuationPostponementTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMaximumDaysOfPostponement()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationPostponementType.ValuationPostponementTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationPostponementType.ValuationPostponementTypeBuilder o = (ValuationPostponementType.ValuationPostponementTypeBuilder) other;
			
			
			merger.mergeBasic(getMaximumDaysOfPostponement(), o.getMaximumDaysOfPostponement(), this::setMaximumDaysOfPostponement);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationPostponementType _that = getType().cast(o);
		
			if (!Objects.equals(maximumDaysOfPostponement, _that.getMaximumDaysOfPostponement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (maximumDaysOfPostponement != null ? maximumDaysOfPostponement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationPostponementTypeBuilder {" +
				"maximumDaysOfPostponement=" + this.maximumDaysOfPostponement +
			'}';
		}
	}
}
