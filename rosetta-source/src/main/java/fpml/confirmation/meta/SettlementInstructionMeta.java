package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementInstruction;
import fpml.confirmation.validation.SettlementInstructionTypeFormatValidator;
import fpml.confirmation.validation.SettlementInstructionValidator;
import fpml.confirmation.validation.exists.SettlementInstructionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementInstruction.class)
public class SettlementInstructionMeta implements RosettaMetaData<SettlementInstruction> {

	@Override
	public List<Validator<? super SettlementInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementInstruction> validator() {
		return new SettlementInstructionValidator();
	}

	@Override
	public Validator<? super SettlementInstruction> typeFormatValidator() {
		return new SettlementInstructionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementInstruction, Set<String>> onlyExistsValidator() {
		return new SettlementInstructionOnlyExistsValidator();
	}
}
