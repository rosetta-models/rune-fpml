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
import fpml.confirmation.FxDisruptionFallback;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilder;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilderImpl;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackImpl;
import fpml.confirmation.Postponement;
import fpml.confirmation.Postponement.PostponementBuilder;
import fpml.confirmation.Postponement.PostponementBuilderImpl;
import fpml.confirmation.Postponement.PostponementImpl;
import fpml.confirmation.meta.PostponementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes a postponement
 * @version ${project.version}
 */
@RosettaDataType(value="Postponement", builder=Postponement.PostponementBuilderImpl.class, version="${project.version}")
public interface Postponement extends FxDisruptionFallback {

	PostponementMeta metaData = new PostponementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The maximum number of days of postponement.
	 */
	Integer getMaximumNumberOfDays();

	/*********************** Build Methods  ***********************/
	Postponement build();
	
	Postponement.PostponementBuilder toBuilder();
	
	static Postponement.PostponementBuilder builder() {
		return new Postponement.PostponementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Postponement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Postponement> getType() {
		return Postponement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("maximumNumberOfDays"), Integer.class, getMaximumNumberOfDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostponementBuilder extends Postponement, FxDisruptionFallback.FxDisruptionFallbackBuilder {
		Postponement.PostponementBuilder setMaximumNumberOfDays(Integer maximumNumberOfDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("maximumNumberOfDays"), Integer.class, getMaximumNumberOfDays(), this);
		}
		

		Postponement.PostponementBuilder prune();
	}

	/*********************** Immutable Implementation of Postponement  ***********************/
	class PostponementImpl extends FxDisruptionFallback.FxDisruptionFallbackImpl implements Postponement {
		private final Integer maximumNumberOfDays;
		
		protected PostponementImpl(Postponement.PostponementBuilder builder) {
			super(builder);
			this.maximumNumberOfDays = builder.getMaximumNumberOfDays();
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfDays")
		public Integer getMaximumNumberOfDays() {
			return maximumNumberOfDays;
		}
		
		@Override
		public Postponement build() {
			return this;
		}
		
		@Override
		public Postponement.PostponementBuilder toBuilder() {
			Postponement.PostponementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Postponement.PostponementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMaximumNumberOfDays()).ifPresent(builder::setMaximumNumberOfDays);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Postponement _that = getType().cast(o);
		
			if (!Objects.equals(maximumNumberOfDays, _that.getMaximumNumberOfDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (maximumNumberOfDays != null ? maximumNumberOfDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Postponement {" +
				"maximumNumberOfDays=" + this.maximumNumberOfDays +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Postponement  ***********************/
	class PostponementBuilderImpl extends FxDisruptionFallback.FxDisruptionFallbackBuilderImpl  implements Postponement.PostponementBuilder {
	
		protected Integer maximumNumberOfDays;
	
		public PostponementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("maximumNumberOfDays")
		public Integer getMaximumNumberOfDays() {
			return maximumNumberOfDays;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfDays")
		public Postponement.PostponementBuilder setMaximumNumberOfDays(Integer maximumNumberOfDays) {
			this.maximumNumberOfDays = maximumNumberOfDays==null?null:maximumNumberOfDays;
			return this;
		}
		
		@Override
		public Postponement build() {
			return new Postponement.PostponementImpl(this);
		}
		
		@Override
		public Postponement.PostponementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Postponement.PostponementBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMaximumNumberOfDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Postponement.PostponementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Postponement.PostponementBuilder o = (Postponement.PostponementBuilder) other;
			
			
			merger.mergeBasic(getMaximumNumberOfDays(), o.getMaximumNumberOfDays(), this::setMaximumNumberOfDays);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Postponement _that = getType().cast(o);
		
			if (!Objects.equals(maximumNumberOfDays, _that.getMaximumNumberOfDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (maximumNumberOfDays != null ? maximumNumberOfDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostponementBuilder {" +
				"maximumNumberOfDays=" + this.maximumNumberOfDays +
			'}' + " " + super.toString();
		}
	}
}
