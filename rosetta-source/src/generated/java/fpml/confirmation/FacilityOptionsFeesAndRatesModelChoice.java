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
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilderImpl;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceImpl;
import fpml.confirmation.FixedRateOption;
import fpml.confirmation.FloatingRateOption;
import fpml.confirmation.LcOption;
import fpml.confirmation.meta.FacilityOptionsFeesAndRatesModelChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FacilityOptionsFeesAndRatesModelChoice", builder=FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilderImpl.class, version="${project.version}")
public interface FacilityOptionsFeesAndRatesModelChoice extends RosettaModelObject {

	FacilityOptionsFeesAndRatesModelChoiceMeta metaData = new FacilityOptionsFeesAndRatesModelChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A set of default cash accrual options. Each option is usually available to any borrowers defined within the facility, but an explicitly defined set of borrower entities (within the option) or be applicable to all borrower(s) within the facility.
	 */
	FixedRateOption getFixedRateOption();
	/**
	 * A set of default cash accrual options. Each option is usually available to any borrowers defined within the facility, but an explicitly defined set of borrower entities (within the option) or be applicable to all borrower(s) within the facility.
	 */
	FloatingRateOption getFloatingRateOption();
	/**
	 * A description of all the letter of credit fee types which apply to the facility.
	 */
	LcOption getLcOption();

	/*********************** Build Methods  ***********************/
	FacilityOptionsFeesAndRatesModelChoice build();
	
	FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder toBuilder();
	
	static FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder builder() {
		return new FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityOptionsFeesAndRatesModelChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FacilityOptionsFeesAndRatesModelChoice> getType() {
		return FacilityOptionsFeesAndRatesModelChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedRateOption"), processor, FixedRateOption.class, getFixedRateOption());
		processRosetta(path.newSubPath("floatingRateOption"), processor, FloatingRateOption.class, getFloatingRateOption());
		processRosetta(path.newSubPath("lcOption"), processor, LcOption.class, getLcOption());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityOptionsFeesAndRatesModelChoiceBuilder extends FacilityOptionsFeesAndRatesModelChoice, RosettaModelObjectBuilder {
		FixedRateOption.FixedRateOptionBuilder getOrCreateFixedRateOption();
		FixedRateOption.FixedRateOptionBuilder getFixedRateOption();
		FloatingRateOption.FloatingRateOptionBuilder getOrCreateFloatingRateOption();
		FloatingRateOption.FloatingRateOptionBuilder getFloatingRateOption();
		LcOption.LcOptionBuilder getOrCreateLcOption();
		LcOption.LcOptionBuilder getLcOption();
		FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder setFixedRateOption(FixedRateOption fixedRateOption);
		FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder setFloatingRateOption(FloatingRateOption floatingRateOption);
		FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder setLcOption(LcOption lcOption);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedRateOption"), processor, FixedRateOption.FixedRateOptionBuilder.class, getFixedRateOption());
			processRosetta(path.newSubPath("floatingRateOption"), processor, FloatingRateOption.FloatingRateOptionBuilder.class, getFloatingRateOption());
			processRosetta(path.newSubPath("lcOption"), processor, LcOption.LcOptionBuilder.class, getLcOption());
		}
		

		FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityOptionsFeesAndRatesModelChoice  ***********************/
	class FacilityOptionsFeesAndRatesModelChoiceImpl implements FacilityOptionsFeesAndRatesModelChoice {
		private final FixedRateOption fixedRateOption;
		private final FloatingRateOption floatingRateOption;
		private final LcOption lcOption;
		
		protected FacilityOptionsFeesAndRatesModelChoiceImpl(FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder builder) {
			this.fixedRateOption = ofNullable(builder.getFixedRateOption()).map(f->f.build()).orElse(null);
			this.floatingRateOption = ofNullable(builder.getFloatingRateOption()).map(f->f.build()).orElse(null);
			this.lcOption = ofNullable(builder.getLcOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedRateOption")
		public FixedRateOption getFixedRateOption() {
			return fixedRateOption;
		}
		
		@Override
		@RosettaAttribute("floatingRateOption")
		public FloatingRateOption getFloatingRateOption() {
			return floatingRateOption;
		}
		
		@Override
		@RosettaAttribute("lcOption")
		public LcOption getLcOption() {
			return lcOption;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModelChoice build() {
			return this;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder toBuilder() {
			FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder builder) {
			ofNullable(getFixedRateOption()).ifPresent(builder::setFixedRateOption);
			ofNullable(getFloatingRateOption()).ifPresent(builder::setFloatingRateOption);
			ofNullable(getLcOption()).ifPresent(builder::setLcOption);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityOptionsFeesAndRatesModelChoice _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOption, _that.getFixedRateOption())) return false;
			if (!Objects.equals(floatingRateOption, _that.getFloatingRateOption())) return false;
			if (!Objects.equals(lcOption, _that.getLcOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateOption != null ? fixedRateOption.hashCode() : 0);
			_result = 31 * _result + (floatingRateOption != null ? floatingRateOption.hashCode() : 0);
			_result = 31 * _result + (lcOption != null ? lcOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityOptionsFeesAndRatesModelChoice {" +
				"fixedRateOption=" + this.fixedRateOption + ", " +
				"floatingRateOption=" + this.floatingRateOption + ", " +
				"lcOption=" + this.lcOption +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityOptionsFeesAndRatesModelChoice  ***********************/
	class FacilityOptionsFeesAndRatesModelChoiceBuilderImpl implements FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder {
	
		protected FixedRateOption.FixedRateOptionBuilder fixedRateOption;
		protected FloatingRateOption.FloatingRateOptionBuilder floatingRateOption;
		protected LcOption.LcOptionBuilder lcOption;
	
		public FacilityOptionsFeesAndRatesModelChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedRateOption")
		public FixedRateOption.FixedRateOptionBuilder getFixedRateOption() {
			return fixedRateOption;
		}
		
		@Override
		public FixedRateOption.FixedRateOptionBuilder getOrCreateFixedRateOption() {
			FixedRateOption.FixedRateOptionBuilder result;
			if (fixedRateOption!=null) {
				result = fixedRateOption;
			}
			else {
				result = fixedRateOption = FixedRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateOption")
		public FloatingRateOption.FloatingRateOptionBuilder getFloatingRateOption() {
			return floatingRateOption;
		}
		
		@Override
		public FloatingRateOption.FloatingRateOptionBuilder getOrCreateFloatingRateOption() {
			FloatingRateOption.FloatingRateOptionBuilder result;
			if (floatingRateOption!=null) {
				result = floatingRateOption;
			}
			else {
				result = floatingRateOption = FloatingRateOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lcOption")
		public LcOption.LcOptionBuilder getLcOption() {
			return lcOption;
		}
		
		@Override
		public LcOption.LcOptionBuilder getOrCreateLcOption() {
			LcOption.LcOptionBuilder result;
			if (lcOption!=null) {
				result = lcOption;
			}
			else {
				result = lcOption = LcOption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedRateOption")
		public FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder setFixedRateOption(FixedRateOption fixedRateOption) {
			this.fixedRateOption = fixedRateOption==null?null:fixedRateOption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateOption")
		public FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder setFloatingRateOption(FloatingRateOption floatingRateOption) {
			this.floatingRateOption = floatingRateOption==null?null:floatingRateOption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lcOption")
		public FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder setLcOption(LcOption lcOption) {
			this.lcOption = lcOption==null?null:lcOption.toBuilder();
			return this;
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModelChoice build() {
			return new FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceImpl(this);
		}
		
		@Override
		public FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder prune() {
			if (fixedRateOption!=null && !fixedRateOption.prune().hasData()) fixedRateOption = null;
			if (floatingRateOption!=null && !floatingRateOption.prune().hasData()) floatingRateOption = null;
			if (lcOption!=null && !lcOption.prune().hasData()) lcOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedRateOption()!=null && getFixedRateOption().hasData()) return true;
			if (getFloatingRateOption()!=null && getFloatingRateOption().hasData()) return true;
			if (getLcOption()!=null && getLcOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder o = (FacilityOptionsFeesAndRatesModelChoice.FacilityOptionsFeesAndRatesModelChoiceBuilder) other;
			
			merger.mergeRosetta(getFixedRateOption(), o.getFixedRateOption(), this::setFixedRateOption);
			merger.mergeRosetta(getFloatingRateOption(), o.getFloatingRateOption(), this::setFloatingRateOption);
			merger.mergeRosetta(getLcOption(), o.getLcOption(), this::setLcOption);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityOptionsFeesAndRatesModelChoice _that = getType().cast(o);
		
			if (!Objects.equals(fixedRateOption, _that.getFixedRateOption())) return false;
			if (!Objects.equals(floatingRateOption, _that.getFloatingRateOption())) return false;
			if (!Objects.equals(lcOption, _that.getLcOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedRateOption != null ? fixedRateOption.hashCode() : 0);
			_result = 31 * _result + (floatingRateOption != null ? floatingRateOption.hashCode() : 0);
			_result = 31 * _result + (lcOption != null ? lcOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityOptionsFeesAndRatesModelChoiceBuilder {" +
				"fixedRateOption=" + this.fixedRateOption + ", " +
				"floatingRateOption=" + this.floatingRateOption + ", " +
				"lcOption=" + this.lcOption +
			'}';
		}
	}
}
