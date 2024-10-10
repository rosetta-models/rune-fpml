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
import fpml.confirmation.NonNegativeAmountSchedule;
import fpml.confirmation.Notional;
import fpml.confirmation.Notional.NotionalBuilder;
import fpml.confirmation.Notional.NotionalBuilderImpl;
import fpml.confirmation.Notional.NotionalImpl;
import fpml.confirmation.NotionalStepRule;
import fpml.confirmation.meta.NotionalMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An type defining the notional amount or notional amount schedule associated with a swap stream. The notional schedule will be captured explicitly, specifying the dates that the notional changes and the outstanding notional amount that applies from that date. A parametric representation of the rules defining the notional step schedule can optionally be included.
 * @version ${project.version}
 */
@RosettaDataType(value="Notional", builder=Notional.NotionalBuilderImpl.class, version="${project.version}")
public interface Notional extends RosettaModelObject {

	NotionalMeta metaData = new NotionalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The notional amount or notional amount schedule expressed as explicit outstanding notional amounts and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 */
	NonNegativeAmountSchedule getNotionalStepSchedule();
	/**
	 * A parametric representation of the notional step schedule, i.e. parameters used to generate the notional schedule.
	 */
	NotionalStepRule getNotionalStepParameters();
	String getId();

	/*********************** Build Methods  ***********************/
	Notional build();
	
	Notional.NotionalBuilder toBuilder();
	
	static Notional.NotionalBuilder builder() {
		return new Notional.NotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Notional> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Notional> getType() {
		return Notional.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalStepSchedule"), processor, NonNegativeAmountSchedule.class, getNotionalStepSchedule());
		processRosetta(path.newSubPath("notionalStepParameters"), processor, NotionalStepRule.class, getNotionalStepParameters());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalBuilder extends Notional, RosettaModelObjectBuilder {
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalStepSchedule();
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalStepSchedule();
		NotionalStepRule.NotionalStepRuleBuilder getOrCreateNotionalStepParameters();
		NotionalStepRule.NotionalStepRuleBuilder getNotionalStepParameters();
		Notional.NotionalBuilder setNotionalStepSchedule(NonNegativeAmountSchedule notionalStepSchedule);
		Notional.NotionalBuilder setNotionalStepParameters(NotionalStepRule notionalStepParameters);
		Notional.NotionalBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalStepSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalStepSchedule());
			processRosetta(path.newSubPath("notionalStepParameters"), processor, NotionalStepRule.NotionalStepRuleBuilder.class, getNotionalStepParameters());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Notional.NotionalBuilder prune();
	}

	/*********************** Immutable Implementation of Notional  ***********************/
	class NotionalImpl implements Notional {
		private final NonNegativeAmountSchedule notionalStepSchedule;
		private final NotionalStepRule notionalStepParameters;
		private final String id;
		
		protected NotionalImpl(Notional.NotionalBuilder builder) {
			this.notionalStepSchedule = ofNullable(builder.getNotionalStepSchedule()).map(f->f.build()).orElse(null);
			this.notionalStepParameters = ofNullable(builder.getNotionalStepParameters()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("notionalStepSchedule")
		public NonNegativeAmountSchedule getNotionalStepSchedule() {
			return notionalStepSchedule;
		}
		
		@Override
		@RosettaAttribute("notionalStepParameters")
		public NotionalStepRule getNotionalStepParameters() {
			return notionalStepParameters;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Notional build() {
			return this;
		}
		
		@Override
		public Notional.NotionalBuilder toBuilder() {
			Notional.NotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Notional.NotionalBuilder builder) {
			ofNullable(getNotionalStepSchedule()).ifPresent(builder::setNotionalStepSchedule);
			ofNullable(getNotionalStepParameters()).ifPresent(builder::setNotionalStepParameters);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Notional _that = getType().cast(o);
		
			if (!Objects.equals(notionalStepSchedule, _that.getNotionalStepSchedule())) return false;
			if (!Objects.equals(notionalStepParameters, _that.getNotionalStepParameters())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalStepSchedule != null ? notionalStepSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalStepParameters != null ? notionalStepParameters.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Notional {" +
				"notionalStepSchedule=" + this.notionalStepSchedule + ", " +
				"notionalStepParameters=" + this.notionalStepParameters + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Notional  ***********************/
	class NotionalBuilderImpl implements Notional.NotionalBuilder {
	
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalStepSchedule;
		protected NotionalStepRule.NotionalStepRuleBuilder notionalStepParameters;
		protected String id;
	
		public NotionalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalStepSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalStepSchedule() {
			return notionalStepSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalStepSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalStepSchedule!=null) {
				result = notionalStepSchedule;
			}
			else {
				result = notionalStepSchedule = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalStepParameters")
		public NotionalStepRule.NotionalStepRuleBuilder getNotionalStepParameters() {
			return notionalStepParameters;
		}
		
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder getOrCreateNotionalStepParameters() {
			NotionalStepRule.NotionalStepRuleBuilder result;
			if (notionalStepParameters!=null) {
				result = notionalStepParameters;
			}
			else {
				result = notionalStepParameters = NotionalStepRule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("notionalStepSchedule")
		public Notional.NotionalBuilder setNotionalStepSchedule(NonNegativeAmountSchedule notionalStepSchedule) {
			this.notionalStepSchedule = notionalStepSchedule==null?null:notionalStepSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalStepParameters")
		public Notional.NotionalBuilder setNotionalStepParameters(NotionalStepRule notionalStepParameters) {
			this.notionalStepParameters = notionalStepParameters==null?null:notionalStepParameters.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Notional.NotionalBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Notional build() {
			return new Notional.NotionalImpl(this);
		}
		
		@Override
		public Notional.NotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Notional.NotionalBuilder prune() {
			if (notionalStepSchedule!=null && !notionalStepSchedule.prune().hasData()) notionalStepSchedule = null;
			if (notionalStepParameters!=null && !notionalStepParameters.prune().hasData()) notionalStepParameters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalStepSchedule()!=null && getNotionalStepSchedule().hasData()) return true;
			if (getNotionalStepParameters()!=null && getNotionalStepParameters().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Notional.NotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Notional.NotionalBuilder o = (Notional.NotionalBuilder) other;
			
			merger.mergeRosetta(getNotionalStepSchedule(), o.getNotionalStepSchedule(), this::setNotionalStepSchedule);
			merger.mergeRosetta(getNotionalStepParameters(), o.getNotionalStepParameters(), this::setNotionalStepParameters);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Notional _that = getType().cast(o);
		
			if (!Objects.equals(notionalStepSchedule, _that.getNotionalStepSchedule())) return false;
			if (!Objects.equals(notionalStepParameters, _that.getNotionalStepParameters())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalStepSchedule != null ? notionalStepSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalStepParameters != null ? notionalStepParameters.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalBuilder {" +
				"notionalStepSchedule=" + this.notionalStepSchedule + ", " +
				"notionalStepParameters=" + this.notionalStepParameters + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
