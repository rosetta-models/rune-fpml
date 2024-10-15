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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.AdjustableOrRelativeDates;
import fpml.confirmation.ReturnSwapPaymentDates;
import fpml.confirmation.ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder;
import fpml.confirmation.ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilderImpl;
import fpml.confirmation.ReturnSwapPaymentDates.ReturnSwapPaymentDatesImpl;
import fpml.confirmation.meta.ReturnSwapPaymentDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the return payment dates of the swap.
 * @version ${project.version}
 */
@RosettaDataType(value="ReturnSwapPaymentDates", builder=ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilderImpl.class, version="${project.version}")
public interface ReturnSwapPaymentDates extends RosettaModelObject {

	ReturnSwapPaymentDatesMeta metaData = new ReturnSwapPaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the interim payment dates of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDates component), this element will typically refer to the valuation dates and add a lag corresponding to the settlement cycle of the underlyer.
	 */
	AdjustableOrRelativeDates getPaymentDatesInterim();
	/**
	 * Specifies the final payment date of the swap. When defined in relation to a date specified somewhere else in the document (through the relativeDate component), this element will typically refer to the final valuation date and add a lag corresponding to the settlement cycle of the underlyer.
	 */
	AdjustableOrRelativeDate getPaymentDateFinal();
	String getId();

	/*********************** Build Methods  ***********************/
	ReturnSwapPaymentDates build();
	
	ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder toBuilder();
	
	static ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder builder() {
		return new ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReturnSwapPaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ReturnSwapPaymentDates> getType() {
		return ReturnSwapPaymentDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("paymentDatesInterim"), processor, AdjustableOrRelativeDates.class, getPaymentDatesInterim());
		processRosetta(path.newSubPath("paymentDateFinal"), processor, AdjustableOrRelativeDate.class, getPaymentDateFinal());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnSwapPaymentDatesBuilder extends ReturnSwapPaymentDates, RosettaModelObjectBuilder {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreatePaymentDatesInterim();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getPaymentDatesInterim();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDateFinal();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDateFinal();
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setPaymentDatesInterim(AdjustableOrRelativeDates paymentDatesInterim);
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setPaymentDateFinal(AdjustableOrRelativeDate paymentDateFinal);
		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("paymentDatesInterim"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getPaymentDatesInterim());
			processRosetta(path.newSubPath("paymentDateFinal"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDateFinal());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of ReturnSwapPaymentDates  ***********************/
	class ReturnSwapPaymentDatesImpl implements ReturnSwapPaymentDates {
		private final AdjustableOrRelativeDates paymentDatesInterim;
		private final AdjustableOrRelativeDate paymentDateFinal;
		private final String id;
		
		protected ReturnSwapPaymentDatesImpl(ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder builder) {
			this.paymentDatesInterim = ofNullable(builder.getPaymentDatesInterim()).map(f->f.build()).orElse(null);
			this.paymentDateFinal = ofNullable(builder.getPaymentDateFinal()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("paymentDatesInterim")
		public AdjustableOrRelativeDates getPaymentDatesInterim() {
			return paymentDatesInterim;
		}
		
		@Override
		@RosettaAttribute("paymentDateFinal")
		public AdjustableOrRelativeDate getPaymentDateFinal() {
			return paymentDateFinal;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public ReturnSwapPaymentDates build() {
			return this;
		}
		
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder toBuilder() {
			ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder builder) {
			ofNullable(getPaymentDatesInterim()).ifPresent(builder::setPaymentDatesInterim);
			ofNullable(getPaymentDateFinal()).ifPresent(builder::setPaymentDateFinal);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapPaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(paymentDatesInterim, _that.getPaymentDatesInterim())) return false;
			if (!Objects.equals(paymentDateFinal, _that.getPaymentDateFinal())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDatesInterim != null ? paymentDatesInterim.hashCode() : 0);
			_result = 31 * _result + (paymentDateFinal != null ? paymentDateFinal.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapPaymentDates {" +
				"paymentDatesInterim=" + this.paymentDatesInterim + ", " +
				"paymentDateFinal=" + this.paymentDateFinal + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of ReturnSwapPaymentDates  ***********************/
	class ReturnSwapPaymentDatesBuilderImpl implements ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder {
	
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder paymentDatesInterim;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDateFinal;
		protected String id;
	
		public ReturnSwapPaymentDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("paymentDatesInterim")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getPaymentDatesInterim() {
			return paymentDatesInterim;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreatePaymentDatesInterim() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (paymentDatesInterim!=null) {
				result = paymentDatesInterim;
			}
			else {
				result = paymentDatesInterim = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDateFinal")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDateFinal() {
			return paymentDateFinal;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDateFinal() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDateFinal!=null) {
				result = paymentDateFinal;
			}
			else {
				result = paymentDateFinal = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("paymentDatesInterim")
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setPaymentDatesInterim(AdjustableOrRelativeDates paymentDatesInterim) {
			this.paymentDatesInterim = paymentDatesInterim==null?null:paymentDatesInterim.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDateFinal")
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setPaymentDateFinal(AdjustableOrRelativeDate paymentDateFinal) {
			this.paymentDateFinal = paymentDateFinal==null?null:paymentDateFinal.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public ReturnSwapPaymentDates build() {
			return new ReturnSwapPaymentDates.ReturnSwapPaymentDatesImpl(this);
		}
		
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder prune() {
			if (paymentDatesInterim!=null && !paymentDatesInterim.prune().hasData()) paymentDatesInterim = null;
			if (paymentDateFinal!=null && !paymentDateFinal.prune().hasData()) paymentDateFinal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPaymentDatesInterim()!=null && getPaymentDatesInterim().hasData()) return true;
			if (getPaymentDateFinal()!=null && getPaymentDateFinal().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder o = (ReturnSwapPaymentDates.ReturnSwapPaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPaymentDatesInterim(), o.getPaymentDatesInterim(), this::setPaymentDatesInterim);
			merger.mergeRosetta(getPaymentDateFinal(), o.getPaymentDateFinal(), this::setPaymentDateFinal);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReturnSwapPaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(paymentDatesInterim, _that.getPaymentDatesInterim())) return false;
			if (!Objects.equals(paymentDateFinal, _that.getPaymentDateFinal())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (paymentDatesInterim != null ? paymentDatesInterim.hashCode() : 0);
			_result = 31 * _result + (paymentDateFinal != null ? paymentDateFinal.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnSwapPaymentDatesBuilder {" +
				"paymentDatesInterim=" + this.paymentDatesInterim + ", " +
				"paymentDateFinal=" + this.paymentDateFinal + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
