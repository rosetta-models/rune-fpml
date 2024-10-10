package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.validation.EquityExerciseValuationSettlementTypeFormatValidator;
import fpml.confirmation.validation.EquityExerciseValuationSettlementValidator;
import fpml.confirmation.validation.exists.EquityExerciseValuationSettlementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EquityExerciseValuationSettlement.class)
public class EquityExerciseValuationSettlementMeta implements RosettaMetaData<EquityExerciseValuationSettlement> {

	@Override
	public List<Validator<? super EquityExerciseValuationSettlement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EquityExerciseValuationSettlement>create(fpml.confirmation.validation.datarule.EquityExerciseValuationSettlementChoice0.class),
			factory.<fpml.confirmation.EquityExerciseValuationSettlement>create(fpml.confirmation.validation.datarule.EquityExerciseValuationSettlementChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super EquityExerciseValuationSettlement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EquityExerciseValuationSettlement> validator() {
		return new EquityExerciseValuationSettlementValidator();
	}

	@Override
	public Validator<? super EquityExerciseValuationSettlement> typeFormatValidator() {
		return new EquityExerciseValuationSettlementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityExerciseValuationSettlement, Set<String>> onlyExistsValidator() {
		return new EquityExerciseValuationSettlementOnlyExistsValidator();
	}
}
