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
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.DeterminationMethodReference;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.ReturnSwapNotional.ReturnSwapNotionalBuilder;
import fpml.confirmation.ReturnSwapNotional.ReturnSwapNotionalBuilderImpl;
import fpml.confirmation.ReturnSwapNotional.ReturnSwapNotionalImpl;
import fpml.confirmation.ReturnSwapNotionalAmountReference;
import fpml.confirmation.meta.ReturnSwapNotionalMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the notional of return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ReturnSwapNotional", builder=ReturnSwapNotional.ReturnSwapNotionalBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ReturnSwapNotional extends RosettaModelObject {

	ReturnSwapNotionalMeta metaData = new ReturnSwapNotionalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the return swap notional amount defined elsewhere in this document.
	 */
	ReturnSwapNotionalAmountReference getRelativeNotionalAmount();
	/**
	 * A reference to the return swap notional determination method defined elsewhere in this document.
	 */
	DeterminationMethodReference getRelativeDeterminationMethod();
	/**
	 * Specifies the method according to which an amount or a date is determined.
	 */
	DeterminationMethod getDeterminationMethod();
	/**
	 * The notional amount.
	 */
	NotionalAmount getNotionalAmount();
	String getId();

	/*********************** Build Methods  ***********************/
	ReturnSwapNotional build();
	
	ReturnSwapNotional.ReturnSwapNotionalBuilder toBuilder();
	
	static ReturnSwapNotional.ReturnSwapNotionalBuilder builder() {
		return new ReturnSwapNotional.ReturnSwapNotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapNotional> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapNotional> getType() {
		return ReturnSwapNotional.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("relativeNotionalAmount"), processor, ReturnSwapNotionalAmountReference.class, getRelativeNotionalAmount());
		processRosetta(path.newSubPath("relativeDeterminationMethod"), processor, DeterminationMethodReference.class, getRelativeDeterminationMethod());
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.class, getNotionalAmount());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapNotionalBuilder extends ReturnSwapNotional, RosettaModelObjectBuilder {
		ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder getOrCreateRelativeNotionalAmount();
		ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder getRelativeNotionalAmount();
		DeterminationMethodReference.DeterminationMethodReferenceBuilder getOrCreateRelativeDeterminationMethod();
		DeterminationMethodReference.DeterminationMethodReferenceBuilder getRelativeDeterminationMethod();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount();
		NotionalAmount.NotionalAmountBuilder getNotionalAmount();
		ReturnSwapNotional.ReturnSwapNotionalBuilder setRelativeNotionalAmount(ReturnSwapNotionalAmountReference relativeNotionalAmount);
		ReturnSwapNotional.ReturnSwapNotionalBuilder setRelativeDeterminationMethod(DeterminationMethodReference relativeDeterminationMethod);
		ReturnSwapNotional.ReturnSwapNotionalBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		ReturnSwapNotional.ReturnSwapNotionalBuilder setNotionalAmount(NotionalAmount notionalAmount);
		ReturnSwapNotional.ReturnSwapNotionalBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("relativeNotionalAmount"), processor, ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder.class, getRelativeNotionalAmount());
			processRosetta(path.newSubPath("relativeDeterminationMethod"), processor, DeterminationMethodReference.DeterminationMethodReferenceBuilder.class, getRelativeDeterminationMethod());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.NotionalAmountBuilder.class, getNotionalAmount());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ReturnSwapNotional.ReturnSwapNotionalBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapNotional  ***********************/
	class ReturnSwapNotionalImpl implements ReturnSwapNotional {
		private final ReturnSwapNotionalAmountReference relativeNotionalAmount;
		private final DeterminationMethodReference relativeDeterminationMethod;
		private final DeterminationMethod determinationMethod;
		private final NotionalAmount notionalAmount;
		private final String id;
		
		protected ReturnSwapNotionalImpl(ReturnSwapNotional.ReturnSwapNotionalBuilder builder) {
			this.relativeNotionalAmount = ofNullable(builder.getRelativeNotionalAmount()).map(f->f.build()).orElse(null);
			this.relativeDeterminationMethod = ofNullable(builder.getRelativeDeterminationMethod()).map(f->f.build()).orElse(null);
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("relativeNotionalAmount")
		public ReturnSwapNotionalAmountReference getRelativeNotionalAmount() {
			return relativeNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("relativeDeterminationMethod")
		public DeterminationMethodReference getRelativeDeterminationMethod() {
			return relativeDeterminationMethod;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ReturnSwapNotional build() {
			return this;
		}
		
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder toBuilder() {
			ReturnSwapNotional.ReturnSwapNotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapNotional.ReturnSwapNotionalBuilder builder) {
			ofNullable(getRelativeNotionalAmount()).ifPresent(builder::setRelativeNotionalAmount);
			ofNullable(getRelativeDeterminationMethod()).ifPresent(builder::setRelativeDeterminationMethod);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapNotional _that = getType().cast(o);
		
			if (!Objects.equals(relativeNotionalAmount, _that.getRelativeNotionalAmount())) return false;
			if (!Objects.equals(relativeDeterminationMethod, _that.getRelativeDeterminationMethod())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relativeNotionalAmount != null ? relativeNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (relativeDeterminationMethod != null ? relativeDeterminationMethod.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapNotional {" +
				"relativeNotionalAmount=" + this.relativeNotionalAmount + ", " +
				"relativeDeterminationMethod=" + this.relativeDeterminationMethod + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnSwapNotional  ***********************/
	class ReturnSwapNotionalBuilderImpl implements ReturnSwapNotional.ReturnSwapNotionalBuilder {
	
		protected ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder relativeNotionalAmount;
		protected DeterminationMethodReference.DeterminationMethodReferenceBuilder relativeDeterminationMethod;
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected NotionalAmount.NotionalAmountBuilder notionalAmount;
		protected String id;
	
		public ReturnSwapNotionalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("relativeNotionalAmount")
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder getRelativeNotionalAmount() {
			return relativeNotionalAmount;
		}
		
		@Override
		public ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder getOrCreateRelativeNotionalAmount() {
			ReturnSwapNotionalAmountReference.ReturnSwapNotionalAmountReferenceBuilder result;
			if (relativeNotionalAmount!=null) {
				result = relativeNotionalAmount;
			}
			else {
				result = relativeNotionalAmount = ReturnSwapNotionalAmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDeterminationMethod")
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder getRelativeDeterminationMethod() {
			return relativeDeterminationMethod;
		}
		
		@Override
		public DeterminationMethodReference.DeterminationMethodReferenceBuilder getOrCreateRelativeDeterminationMethod() {
			DeterminationMethodReference.DeterminationMethodReferenceBuilder result;
			if (relativeDeterminationMethod!=null) {
				result = relativeDeterminationMethod;
			}
			else {
				result = relativeDeterminationMethod = DeterminationMethodReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NotionalAmount.NotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount() {
			NotionalAmount.NotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NotionalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("relativeNotionalAmount")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setRelativeNotionalAmount(ReturnSwapNotionalAmountReference relativeNotionalAmount) {
			this.relativeNotionalAmount = relativeNotionalAmount==null?null:relativeNotionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDeterminationMethod")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setRelativeDeterminationMethod(DeterminationMethodReference relativeDeterminationMethod) {
			this.relativeDeterminationMethod = relativeDeterminationMethod==null?null:relativeDeterminationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("determinationMethod")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setDeterminationMethod(DeterminationMethod determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notionalAmount")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setNotionalAmount(NotionalAmount notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ReturnSwapNotional build() {
			return new ReturnSwapNotional.ReturnSwapNotionalImpl(this);
		}
		
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder prune() {
			if (relativeNotionalAmount!=null && !relativeNotionalAmount.prune().hasData()) relativeNotionalAmount = null;
			if (relativeDeterminationMethod!=null && !relativeDeterminationMethod.prune().hasData()) relativeDeterminationMethod = null;
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRelativeNotionalAmount()!=null && getRelativeNotionalAmount().hasData()) return true;
			if (getRelativeDeterminationMethod()!=null && getRelativeDeterminationMethod().hasData()) return true;
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnSwapNotional.ReturnSwapNotionalBuilder o = (ReturnSwapNotional.ReturnSwapNotionalBuilder) other;
			
			merger.mergeRosetta(getRelativeNotionalAmount(), o.getRelativeNotionalAmount(), this::setRelativeNotionalAmount);
			merger.mergeRosetta(getRelativeDeterminationMethod(), o.getRelativeDeterminationMethod(), this::setRelativeDeterminationMethod);
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapNotional _that = getType().cast(o);
		
			if (!Objects.equals(relativeNotionalAmount, _that.getRelativeNotionalAmount())) return false;
			if (!Objects.equals(relativeDeterminationMethod, _that.getRelativeDeterminationMethod())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relativeNotionalAmount != null ? relativeNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (relativeDeterminationMethod != null ? relativeDeterminationMethod.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapNotionalBuilder {" +
				"relativeNotionalAmount=" + this.relativeNotionalAmount + ", " +
				"relativeDeterminationMethod=" + this.relativeDeterminationMethod + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
